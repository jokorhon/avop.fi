(ns backend.handler
  (:require
   [backend.virta :as virta]
   [ring.util.response :refer :all]
   [compojure.core :refer :all]
   [compojure.route :as route]
   [ring.middleware.json :refer [wrap-json-response]]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def demo-data 
  {
   :organizationName "Laurea ammattikorkeakoulu",
   :community "Vantaa",
   :degree "Sosionomi (AMK), sosiaaliala",
   :lang "suomi",
   :koulutusmuoto "Päiväopiskelu"})

(defroutes app-routes
  (context 
   "/api" []
   (GET "/" [] "API")
   (GET "/opiskeluoikeudet" []
        (let [virta-resp (virta/get-pending-degrees "aed09afd87a8c6d76b76bbd")]      
          (response virta-resp))))
  (GET "/" [] (redirect "/api"))
  (route/not-found "Not Found"))

(def app
  (wrap-json-response app-routes site-defaults))
