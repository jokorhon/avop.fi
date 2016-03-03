(ns avopfi.routes.api
  (:require [avopfi.layout :as layout]
            [clojure.java.data :refer :all]
            [clojure.core.match :refer [match]]
            [avopfi.integration.virta :as virta]
            [avopfi.integration.shibbo-utils :as shibbo]
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

(def shibbo-attribs 
  ["learner-id" "national-identification-number" "unique-id" "home-organization"])

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
        timespan (virta/select-active-timespan (:jakso degree))
        community-id (:koulutuskunta timespan)
        education-id (:koulutuskoodi timespan)
        org-id (-> degree :myontaja :koodi)
        lang (:koulutuskieli timespan)
        community (op/extract-metadata (op/get-kunta-data community-id))
        education (op/extract-metadata (op/get-koulutus-data education-id))
        education-type (virta/conclude-study-type 
                        (degree :tyyppi) 
                        (degree :aikuiskoulutus))
        org (op/extract-metadata (op/get-oppilaitos-data org-id))]
    {:community {:id community-id :name  community} 
     :lang lang 
     :degree {:id education-id :name education}
     :type education-type
     :organization {:id org-id :name org}
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

(defn request->study-rights [request attribs]
  (let [shibbo-vals
        (shibbo/get-attributes attribs request env)
        virta-degrees (get-virta-degrees shibbo-vals)
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
      (ok (request->study-rights request shibbo-attribs)))
    (POST "/vastaus" request (ok (process-registration request))))
  (GET "/auth" {:keys [headers params body] :as request} 
    (ok 
     (:headers request)))  
  (GET "/" [] (found "/api")))

(defroutes public-routes
  (context "/public" []
    (GET "/students/:study-right-id{.{0,100}}" [study-right-id] 
      (get-visitors study-right-id)))
  )
