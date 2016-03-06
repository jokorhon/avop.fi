(ns avopfi.routes.api
  (:require [avopfi.layout :as layout]
            [buddy.auth :refer [throw-unauthorized]]
            [clojure.java.data :refer :all]
            [clojure.core.match :refer [match]]
            [avopfi.integration.virta :as virta]
            [avopfi.integration.opintopolku :as op]
            [avopfi.db.core :as db]
            [config.core :refer [env]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.http-response :refer :all]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
   "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn get-oppilaitos-code-by-domain [domain]
  (let [mapping 
        (db/get-mapping-by-domain {:domain domain})] (:code mapping)))

(defn has-organization? [home-organization degree]
  (let 
      [code (get-oppilaitos-code-by-domain home-organization)] 
    (= code (-> degree :myontaja :koodi))))

(defn degree->ui-map 
  [degree]
  (let [
        degree-id (:avain degree)
        timespan (virta/select-active-timespan (:jakso degree))
        municipality-id (:koulutuskunta timespan)
        education-id (:koulutuskoodi timespan)
        org-id (-> degree :myontaja :koodi)
        lang (:koulutuskieli timespan)
        municipality (op/extract-metadata (op/get-municipality-data municipality-id))
        education (op/extract-metadata (op/get-education-data education-id))
        education-type (virta/conclude-study-type 
                        (degree :tyyppi) 
                        (degree :aikuiskoulutus))
        school (op/extract-metadata (op/get-school-data org-id))]
    {
     :id degree-id
     :municipality {:id municipality-id :name  municipality}
     :lang lang 
     :degree {:id education-id :name education}
     :type education-type
     :school {:id org-id :name school}
     }))

(defn filter-degrees [virta-degrees home-organization]
  (try 
    (->>
     virta-degrees
     (filter (partial has-organization? home-organization))
     (map degree->ui-map))
    (catch Exception e 
      (let [msg (.getMessage e)] 
        (println "caught exception: " msg) 
        (throw e)))))

(defn get-virta-degrees [shibbo-vals]
  (match [shibbo-vals]
         [{"learner-id" l}] 
           (virta/get-pending-degrees-by-oid l)
         [(:or {"national-identification-number" n} {"unique-id" n})] 
           (virta/get-pending-degrees-by-pid n)
         :else nil))

(defn shibbo-vals->study-rights [shibbo-vals]
  (let [virta-degrees (get-virta-degrees shibbo-vals)
        valid-rights 
        (filter-degrees virta-degrees (shibbo-vals "home-organization"))]
    valid-rights))

(defn process-registration [request]
  (db/create-visitor! {:study_right_id "foo" :arvo_answer_hash "FOOXX71"}))

(defn get-visitors [study-right-id]
  (db/get-visitors-by-srid {:study_right_id study-right-id}))

(defroutes api-routes
  (context 
      "/api" []
    (GET "/" [] (home-page))
    (GET "/opiskeluoikeudet" request
      (let [shibbo-vals (:identity request)]
        (if (not (map? shibbo-vals))
          (throw-unauthorized)
          (ok (shibbo-vals->study-rights shibbo-vals)))))
    (POST "/vastaus" request (ok (process-registration request))))
  (GET "/auth" {:keys [headers params body] :as request} 
    (ok 
     (:headers request)))  
  (GET "/" [] (found "/api")))

(defroutes public-routes
  (context "/public" []
    (GET "/students/:study-right-id{.{0,100}}" [study-right-id :as {i :identity}]
      (if (not (= "valid" i))
        (throw-unauthorized)
        (get-visitors study-right-id)))))
