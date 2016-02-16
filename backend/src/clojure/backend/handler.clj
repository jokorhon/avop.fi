(ns backend.handler
  (:use [clojure.java.data])
  (:require
   [backend.virta :as virta]
   [backend.shibbo-utils :as shibbo]
   [environ.core :refer [env]]
   [ring.util.response :refer :all]
   [ring.adapter.jetty-servlet :as jetty]
   [compojure.core :refer :all]
   [compojure.route :as route]
   [ring.middleware.reload :refer [wrap-reload]]
   [ring.middleware.json :refer [wrap-json-response]]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]) 
  (:gen-class))

(def demo-data 
  {
   :organizationName "Laurea ammattikorkeakoulu",
   :community "Vantaa",
   :degree "Sosionomi (AMK), sosiaaliala",
   :lang "suomi",
   :koulutusmuoto "Päiväopiskelu"})

(def shibbo-attribs 
  ["national-identification-number"])

(defroutes app-routes
  (context 
   "/api" []
    (GET "/" [] "avop.fi API")
    (GET "/opiskeluoikeudet" request
      (let [
            personal-id 
            ( 
             (shibbo/get-attributes shibbo-attribs request env) 
             "national-identification-number")
            virta-resp (virta/get-pending-degrees personal-id)]
        (response virta-resp))))
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
