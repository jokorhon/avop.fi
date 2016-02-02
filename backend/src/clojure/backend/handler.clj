(ns backend.handler
  (:import (fi.csc.virta OpiskelijanTiedotService OpiskeluoikeudetRequest HakuEhdotOrganisaatioVapaa Kutsuja))
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn get-virta-opiskeluoikeudet []
  (let [port (-> (OpiskelijanTiedotService.) 
                 (.getOpiskelijanTiedotSoap11))
        request (doto (OpiskeluoikeudetRequest.)
                  (.setKutsuja 
                   (doto (Kutsuja.) 
                     (.setAvain "salaisuus")
                     (.setJarjestelma "arvofi")
                     (.setTunnus "arvofi")))
                  (.setHakuehdot 
                   (doto (HakuEhdotOrganisaatioVapaa.)
                     (.setKansallinenOppijanumero "aed09afd87a8c6d76b76bbd"))))]
    (.opiskeluoikeudet port request)))

(defroutes app-routes
  (GET "/" [] 
       (let [virta-resp (get-virta-opiskeluoikeudet)]
         (.getKoulutusala2002 
          (first 
           (.getOpiskeluoikeus 
            (.getOpiskeluoikeudet virta-resp))))))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))











