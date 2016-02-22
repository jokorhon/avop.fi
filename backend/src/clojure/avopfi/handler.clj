(ns avopfi.handler
  (:require
   [avopfi.routes :refer [app-routes]]
   [ring.adapter.jetty-servlet :as jetty]
   [ring.middleware.reload :refer [wrap-reload]]
   [ring.middleware.json :refer [wrap-json-response]]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
  (:gen-class))

(def app
  (wrap-json-response app-routes site-defaults))

(defn start-server
  []
  (jetty/run-jetty (wrap-reload  #'app) {:port 3000 :join? false}))

(defn -main [& args]
  (start-server))










