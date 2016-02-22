(ns avopfi.routes
  (:require
   [korma.db :refer :all]
   [korma.core :refer :all]
   [clojure.java.data :refer :all]
   [avopfi.integration.virta :as virta]
   [avopfi.integration.shibbo-utils :as shibbo]
   [avopfi.integration.opintopolku :as op]
   [environ.core :refer [env]]
   [ring.util.response :refer :all]
   [compojure.core :refer :all]
   [compojure.route :as route]))

(defdb 
  db (postgres 
      {:db (:db-name env)
       :user (:db-user env)
       :password (:db-user env)
       :host (:db-host env)
       :port (:db-port env)}))

(declare visits)
(defentity visits
  (pk :id)
  (entity-fields :first :last))

(def shibbo-attribs 
  ["learner-id" "national-identification-number" "unique-id" "home-organization"])

(defn has-organization? [home-organization degree]
  (let 
      [code-from-op (op/get-oppilaitos-code-by-domain home-organization)] 
    (= code-from-op (-> degree :myontaja :koodi))))

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
        (println "caught exception: " msg) {:error msg}))))

(defn get-virta-degrees [shibbo-vals]
  (cond 
    (shibbo-vals "learner-id") 
    (virta/get-pending-degrees-by-oid 
     (shibbo-vals "learner-id")) 
    (shibbo-vals "national-identification-number")
    (virta/get-pending-degrees-by-pid 
     (shibbo-vals "national-identification-number"))
    (shibbo-vals "unique-id")
    (virta/get-pending-degrees-by-pid 
     (shibbo-vals "unique-id"))
    :default nil))

(defn request->study-rights [request]
  (let [shibbo-vals
        (shibbo/get-attributes shibbo-attribs request env)
        virta-degrees (get-virta-degrees shibbo-vals)
        valid-rights (filter-degrees virta-degrees (shibbo-vals "home-organization"))]
    valid-rights))

(defn process-registration [request]
  "post")

(defroutes app-routes
  (context 
   "/api" []
    (GET "/" [] "avop.fi API")
    (GET "/opiskeluoikeudet" request
      (response (request->study-rights request)))
    (POST "/vastaus" request (response (process-registration request))))
  (context "/public" []
    (GET "/students" [] "todo public api"))
  (GET "/auth" {:keys [headers params body] :as request} 
    (response 
     (:headers request)))  
  (GET "/" [] (redirect "/api"))
  (route/not-found "Not Found"))

