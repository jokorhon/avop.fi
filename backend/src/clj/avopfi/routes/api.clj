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

(def opintopisteet-threshold-min 180)
(def opintopisteet-threshold-max 195)

(defn has-enough-opintosuoritus? [virta-suoritukset opiskeluoikeudet]
  (let [pisteet (->> virta-suoritukset
      (filter #(and
                (= (:opiskeluoikeusAvain %) (:avain opiskeluoikeudet))
                (= (:laji %) "2")
                (empty? (:sisaltyvyys %))))
      (reduce #(+ %1 (-> %2 :laajuus :opintopiste)) 0))]
    (and (<= opintopisteet-threshold-min pisteet) (>= opintopisteet-threshold-max pisteet))))

(defn opiskeluoikeus->ui-map
  [opiskeluoikeus]
  (let [
        oikeus-id (:avain opiskeluoikeus)
        timespan (virta/select-active-timespan (:jakso opiskeluoikeus))
        kunta-id (:koulutuskunta timespan)
        koulutus-id (:koulutuskoodi timespan)
        org-id (-> opiskeluoikeus :myontaja :koodi)
        kieli (:koulutuskieli timespan)
        kunta (op/extract-metadata (op/get-kunta-data kunta-id))
        koulutus (op/extract-metadata (op/get-koulutus-data koulutus-id))
        koulutustyyppi (virta/conclude-study-type
                        (opiskeluoikeus :tyyppi)
                        (opiskeluoikeus :aikuiskoulutus))
        oppilaitos (op/extract-metadata (op/get-oppilaitos-data org-id))]
    {
     :id oikeus-id
     :kunta {:id kunta-id :nimi kunta}
     :kieli kieli
     :koulutus {:id koulutus-id :nimi koulutus}
     :tyyppi koulutustyyppi
     :oppilaitos {:id org-id :nimi oppilaitos}
     }))

(defn filter-oikeudet [virta-oikeudet virta-suoritukset home-organization]
  (try
    (->>
      virta-oikeudet
      (filter (partial has-organization? home-organization))
      (filter (partial has-enough-opintosuoritus? virta-suoritukset))
      (map opiskeluoikeus->ui-map))
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

(defn get-virta-suoritukset [shibbo-vals]
  (get-from-virta-with virta/get-opintosuoritukset! shibbo-vals))

(defn get-virta-opiskeluoikeudet [shibbo-vals]
  (get-from-virta-with virta/get-opiskeluoikeudet! shibbo-vals))

(defn shibbo-vals->opiskeluoikeudet [shibbo-vals]
  (let [virta-oikeudet (get-virta-opiskeluoikeudet shibbo-vals)
        virta-suoritukset (get-virta-suoritukset shibbo-vals)
        valid-oikeudet
        (filter-oikeudet virta-oikeudet virta-suoritukset (shibbo-vals "home-organization"))]
    valid-oikeudet))

(defn process-registration [{params :body-params session :session}]
  (let [current-srid (:opiskeluoikeus_id params) opiskeluoikeudet-data (:opiskeluoikeudet-data session)]
    (if (some #(= current-srid (:id %)) opiskeluoikeudet-data)
      (let [res (db/get-visitor-by-srid {:opiskeluoikeus_id current-srid})]
        (if (nil? res)
          (let [arvo-hash (arvo/generate-questionnaire-credentials! opiskeluoikeudet-data)]
            (db/create-visitor! {:opiskeluoikeus_id current-srid
                                 :arvo_answer_hash arvo-hash})
            (ok {:kysely_url (str (:arvo-answer-url env) arvo-hash)}))
            ;; No obviously obvious status code when entity is duplicate,
            ;; (mis)using 422 as some other application/frameworks here.
            (unprocessable-entity
              {:status 422 :detail "Entity already exists" :kysely_url
                       (str (:arvo-answer-url env) (:arvo_answer_hash res))})))
      (throw-unauthorized))))

(defn opiskeluoikeudet [request]
  (let [shibbo-vals (:identity request)]
    (if (not (map? shibbo-vals))
      (throw-unauthorized)
      (let [session (:session request)
            resp-data
            (shibbo-vals->opiskeluoikeudet shibbo-vals)]
        (-> (ok resp-data)
            (assoc :session
                   (assoc session :opiskeluoikeudet-data
                                  resp-data)))))))

(defroutes api-routes
  (context
      "/api" []
    (GET "/" [] (home-page))
    (GET "/opiskeluoikeudet" request
      (opiskeluoikeudet request))
    (POST "/rekisteroidy" request
      (process-registration request))
    (GET "/status"
         {:keys [headers] :as request}
      (let [shibbo-vals (:identity request)]
        (ok {:headers headers :shibbo shibbo-vals}))))
  (GET "/" [] (found "/api")))
