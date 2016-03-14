(ns avopfi.routes.api
  (:require [avopfi.layout :as layout]
            [buddy.auth :refer [throw-unauthorized]]
            [clojure.java.data :refer :all]
            [clojure.core.match :refer [match]]
            [avopfi.integration.virta :as virta]
            [avopfi.integration.opintopolku :as op]
            [avopfi.integration.arvo :as arvo]
            [avopfi.db.core :as db]
            [config.core :refer [env]]
            [compojure.core :refer :all]
            [ring.util.http-response :refer :all]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
   "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn get-oppilaitos-code-by-domain [domain]
  (let [mapping
        (db/get-mapping-by-domain {:domain domain})] (:code mapping)))

(defn has-organization? [home-organization study-right]
  (let
      [code (get-oppilaitos-code-by-domain home-organization)]
    (= code (-> study-right :myontaja :koodi))))

(def credit-threshold-min 180)
(def credit-threshold-max 195)

(defn has-enough-study-credits? [virta-attainments study-right]
  (let [creds (->> virta-attainments
      (filter #(and
                (= (:opiskeluoikeusAvain %) (:avain study-right))
                (= (:laji %) "2")
                (empty? (:sisaltyvyys %))))
      (reduce #(+ %1 (-> %2 :laajuus :opintopiste)) 0))]
    (and (<= credit-threshold-min creds) (>= credit-threshold-max creds))))

(defn study-right->ui-map
  [study-right]
  (let [
        right-id (:avain study-right)
        timespan (virta/select-active-timespan (:jakso study-right))
        municipality-id (:koulutuskunta timespan)
        education-id (:koulutuskoodi timespan)
        org-id (-> study-right :myontaja :koodi)
        lang (:koulutuskieli timespan)
        municipality (op/extract-metadata (op/get-municipality-data municipality-id))
        education (op/extract-metadata (op/get-education-data education-id))
        education-type (virta/conclude-study-type
                        (study-right :tyyppi)
                        (study-right :aikuiskoulutus))
        school (op/extract-metadata (op/get-school-data org-id))]
    {
     :id right-id
     :municipality {:id municipality-id :name municipality}
     :lang lang
     :degree {:id education-id :name education}
     :type education-type
     :school {:id org-id :name school}
     }))

(defn filter-rights [virta-rights virta-attainments home-organization]
  (try
    (->>
      virta-rights
     (filter (partial has-organization? home-organization))
     (filter (partial has-enough-study-credits? virta-attainments))
     (map study-right->ui-map))
    (catch Exception e
      (let [msg (.getMessage e)]
        (println "caught exception: " msg)
        (throw e)))))

(defn get-from-virta-with [virta-fetcher shibbo-vals]
  (match [shibbo-vals]
         [{"learner-id" lid}]
         (virta/get-from-virta-by-oid lid virta-fetcher)
         [(:or {"national-identification-number" nin} {"unique-id" nin})]
         (virta/get-from-virta-by-pid nin virta-fetcher)
         :else nil))

(defn get-virta-attainments [shibbo-vals]
  (get-from-virta-with virta/get-study-attainments! shibbo-vals))

(defn get-virta-rights [shibbo-vals]
  (get-from-virta-with  virta/get-study-rights! shibbo-vals))

(defn shibbo-vals->study-rights [shibbo-vals]
  (let [virta-rights (get-virta-rights shibbo-vals)
        virta-attainments (get-virta-attainments shibbo-vals)
        valid-rights
        (filter-rights virta-rights virta-attainments (shibbo-vals "home-organization"))]
    valid-rights))

(defn process-registration [{params :body-params session :session}]
  (let [current-srid (:study_right_id params) study-rights-data (:study-rights-data session)]
    (if (some #(= current-srid (:id %)) study-rights-data)
      (let [res (db/get-visitor-by-srid {:study_right_id current-srid})]
        (if (nil? res)
          (let [arvo-hash (arvo/generate-questionnaire! study-rights-data)]
            (db/create-visitor! {:study_right_id current-srid
                                 :arvo_answer_hash arvo-hash})
            (ok {:questionnaire_url (str (:arvo-answer-url env) arvo-hash)}))
            ;; No obviously obvious status code when entity is duplicate,
            ;; (mis)using 422 as some other application/frameworks here.
            (unprocessable-entity
              {:status 422 :detail "Entity already exists" :questionnaire_url
                       (str (:arvo-answer-url env) (:arvo_answer_hash res))})))
      (throw-unauthorized))))

(defn study-rights [request]
  (let [shibbo-vals (:identity request)]
    (if (not (map? shibbo-vals))
      (throw-unauthorized)
      (let [session (:session request)
            resp-data
            (shibbo-vals->study-rights shibbo-vals)]
        (-> (ok resp-data)
            (assoc :session
                   (assoc session :study-rights-data
                                  resp-data)))))))

(defroutes api-routes
  (context
      "/api" []
    (GET "/" [] (home-page))
    (GET "/opiskeluoikeudet" request
      (study-rights request))
    (POST "/submit-registration" request
      (process-registration request))
    (GET "/status"
         {:keys [headers] :as request}
      (let [shibbo-vals (:identity request)]
        (ok {:headers headers :shibbo shibbo-vals}))))
  (GET "/" [] (found "/api")))
