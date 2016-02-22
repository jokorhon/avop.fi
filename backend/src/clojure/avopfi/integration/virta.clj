(ns avopfi.integration.virta
  (:use [clojure.java.data])
  (:require
   [environ.core :refer [env]]
   [clojure.tools.logging :as log]
   [java-time :refer :all]
   [environ.core :refer [env]])
  (:import
   (java.net URL)
   (fi.csc.virta OpiskelijanTiedotService OpiskeluoikeudetRequest OpiskeluoikeudetResponse HakuEhdotOrganisaatioVapaa Kutsuja)))

(defn extract-study-enright-data
  "Note: Confusingly one opiskeluoikeudetLaajennettuTyyppi instance 
  is returned with .getOpiskeluoikeudet and multiple OpiskeluoikeusTyyppis
  with getOpiskeluoikeus"
  [^OpiskeluoikeudetResponse opiskeluoikeudet-response]
  (map #(from-java %)
       (.getOpiskeluoikeus
        (.getOpiskeluoikeudet opiskeluoikeudet-response))))

(defn ^:private to-local-date [date-map]
  (local-date (:year date-map) (:month date-map) (:day date-map)))

(defn ^:private compare-timespans [first-timespan second-timespan]
  (let [ld1 (to-local-date (:loppuPvm first-timespan)) ld2 (to-local-date (:loppuPvm second-timespan))]
    (if (> (.compareTo ld1 ld2) 0) first-timespan second-timespan)))

(defn select-active-timespan 
  "Todo: simplify"
  [timespans]
  (let [nonending
        (reduce 
         #(when (nil? (:loppuPvm %2)) (reduced %2)) nil timespans)]
    (if (nil? nonending)
      (reduce compare-timespans timespans)
      nonending)))

(defn conclude-study-type
  "Monimuoto-opiskelu 1, Päiväopiskelu 0"
  [study-type adult-studies]
  (if (and (= study-type "1") adult-studies) 1 0))

(defn get-study-rights!
  "Use Java source generated from wsdl"
  [set-id-query]
  (let [port (-> (OpiskelijanTiedotService. (URL. (env :virta-url)))
                 (.getOpiskelijanTiedotSoap11))
        request (doto (OpiskeluoikeudetRequest.)
                  (.setKutsuja
                   (doto (Kutsuja.)
                     (.setAvain (:virta-salaisuus env))
                     (.setJarjestelma (:virta-jarjestelma env))
                     (.setTunnus (:virta-tunnus env))))
                  (.setHakuehdot
                   (doto (HakuEhdotOrganisaatioVapaa.)
                     set-id-query
                     )))]
    (extract-study-enright-data (.opiskeluoikeudet port request))))

(defn get-pending-degrees-by-pid [person-id]
  (log/debug "fetching by pid: " person-id)
  (let [study-rights (get-study-rights! #(.setHenkilotunnus % person-id))]
    study-rights))

(defn get-pending-degrees-by-oid [oid]
  (log/debug "fetching by oid: " oid)
  (let [study-rights (get-study-rights! #(.setKansallinenOppijanumero % oid))]
    study-rights))
