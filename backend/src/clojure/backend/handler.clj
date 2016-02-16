(ns backend.handler
  (:use 
   [korma.db]
   [korma.core]
   [clojure.java.data])
  (:require
   [backend.virta :as virta]
   [backend.shibbo-utils :as shibbo]
   [backend.opintopolku :as op]
   [environ.core :refer [env]]
   [ring.util.response :refer :all]
   [ring.adapter.jetty-servlet :as jetty]
   [compojure.core :refer :all]
   [compojure.route :as route]
   [ring.middleware.reload :refer [wrap-reload]]
   [ring.middleware.json :refer [wrap-json-response]]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]) 
  (:gen-class))

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

(defn build-opiskeluoikeudet [request]
  (let [personal-id 
        ((shibbo/get-attributes shibbo-attribs request env) 
         "national-identification-number")
        virta-degrees (virta/get-pending-degrees personal-id)
        valid-rights (count virta-degrees)
        ]
    (println valid-rights)
    demo-data))

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

(def app
  (wrap-json-response app-routes site-defaults))

(defn start-server
  []
  (jetty/run-jetty (wrap-reload  #'app) {:port 3000 :join? false}))

(defn -main [& args]
  (start-server))
