(ns backend.virta
  (:use [clojure.java.data])
  (:import 
   (fi.csc.virta OpiskelijanTiedotService OpiskeluoikeudetRequest HakuEhdotOrganisaatioVapaa Kutsuja)))

(defn extract-study-enright-data 
  "Note: Confusingly one opiskeluoikeudetLaajennettuTyyppi instance 
  is returned with .getOpiskeluoikeudet and multiple OpiskeluoikeusTyyppis
  with getOpiskeluoikeus"
  [opiskeluoikeudet-response]
  (map #(from-java %)
       (.getOpiskeluoikeus 
        (.getOpiskeluoikeudet opiskeluoikeudet-response))))

(defn get-study-enrights [person-id]
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
    (extract-study-enright-data (.opiskeluoikeudet port request))))

(defn get-pending-degrees [person-id]
  (let [study-enrights (get-study-enrights person-id)]
    study-enrights))
  
