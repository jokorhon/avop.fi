(ns backend.routes
  (:use 
   [korma.db]
   [korma.core]
   [clojure.java.data])
  (:require
   [backend.integration.virta :as virta]
   [backend.integration.shibbo-utils :as shibbo]
   [backend.integration.opintopolku :as op]
   [environ.core :refer [env]]
   [ring.util.response :refer :all]
   [compojure.core :refer :all]
   [compojure.route :as route]))

;; tyyppi == 1 JA aikuisokoulutus == 1/true -> Monimuoto-opiskelu 2 
;; muuten Päiväopiskelu 1
(def demo-data 
  {:organizationName "Laurea ammattikorkeakoulu",
   :community "Vantaa",
   :degree "Sosionomi (AMK), sosiaaliala",
   :lang "suomi",
   :koulutusmuoto "Päiväopiskelu"})

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
  ["national-identification-number"])

(defn convert-degrees [virta-degrees]
  (map (fn [degree] 
         (try 
           (let [
                 unit (-> degree :jakso first)
                 community-id (:koulutuskunta unit)
                 lang (:koulutuskieli unit)
                 community (op/extract-metadata (op/get-kunta-data community-id))
                 
                 ]
             {:community community}
             )
           (catch Exception e 
             (let [msg (.getMessage e)] 
               (println "caught exception: " msg) {:error msg}))))
       virta-degrees))

(defn build-opiskeluoikeudet [request]
  (let [personal-id 
        ((shibbo/get-attributes shibbo-attribs request env) 
         "national-identification-number")
        virta-degrees (virta/get-pending-degrees personal-id)
        valid-rights (convert-degrees virta-degrees)
        ]
    (println valid-rights)
    valid-rights))

(defroutes app-routes
  (context 
   "/api" []
    (GET "/" [] "avop.fi API")
    (GET "/opiskeluoikeudet" request
      (response (build-opiskeluoikeudet request))))
  (GET "/auth" {:keys [headers params body] :as request} 
    (response 
     (:headers request)))  
  (GET "/" [] (redirect "/api"))
  (route/not-found "Not Found"))









