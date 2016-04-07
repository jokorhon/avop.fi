(ns avopfi.integration.virta
  (:require
    [avopfi.consts :refer :all]
    [config.core :refer [env]]
    [clojure.java.data :refer [from-java]]
    [clojure.tools.logging :as log]
    [java-time :refer [local-date]])
  (:import
    (java.net URL)
    (fi.csc.virta OpiskelijanTiedotService OpiskeluoikeudetRequest
                  OpiskeluoikeudetResponse OpintosuorituksetRequest
                  OpintosuorituksetResponse HakuEhdotOrganisaatioVapaa
                  Kutsuja)))

(defn extract-study-attainments-data
  "Note: Confusingly one opiskeluoikeudetLaajennettuTyyppi instance 
  is returned with .getOpiskeluoikeudet and multiple OpiskeluoikeusTyyppis
  with getOpiskeluoikeus"
  [^OpintosuorituksetResponse opintosuoritukset-response]
  (let [results (some-> opintosuoritukset-response
                    (.getOpintosuoritukset)
                    (.getOpintosuoritus))]
    (map #(from-java %) results)))

(defn extract-opiskeluoikeus-data
  "Note: Confusingly one opiskeluoikeudetLaajennettuTyyppi instance
  is returned with .getOpiskeluoikeudet and multiple OpiskeluoikeusTyyppis
  with getOpiskeluoikeus"
  [^OpiskeluoikeudetResponse opiskeluoikeudet-response]
  (let [results (some-> opiskeluoikeudet-response
                    (.getOpiskeluoikeudet)
                    (.getOpiskeluoikeus))]
    (map #(from-java %) results)))

(defn ^:private to-local-date [date-map]
  (local-date (:year date-map) (:month date-map) (:day date-map)))

(defn ^:private compare-timespans [first-timespan second-timespan]
  (let [ld1 (to-local-date (:loppuPvm first-timespan)) ld2 (to-local-date (:loppuPvm second-timespan))]
    (if (> (.compareTo ld1 ld2) 0) first-timespan second-timespan)))

(defn select-active-timespan 
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

(defn get-caller-obj
  "Object to include VIRTA credentials in WS call"
  []
  (doto (Kutsuja.)
    (.setAvain (:virta-salaisuus env))
    (.setJarjestelma (:virta-jarjestelma env))
    (.setTunnus (:virta-tunnus env))))

(defn get-ws-service []
  (-> (OpiskelijanTiedotService. (URL. (env :virta-url)))
      (.getOpiskelijanTiedotSoap11)))

(defn build-ws-request-from [request-inst set-id-query]
  (doto request-inst
    (.setKutsuja (get-caller-obj))
    (.setHakuehdot
      (doto (HakuEhdotOrganisaatioVapaa.)
        set-id-query))))

(defn get-opintosuoritukset!
  [set-id-query]
  (let [service (get-ws-service)
        request (build-ws-request-from (OpintosuorituksetRequest.) set-id-query)]
    (extract-study-attainments-data (.opintosuoritukset service request))))

(defn get-opiskeluoikeudet!
  [set-id-query]
  (let [service (get-ws-service)
            request (build-ws-request-from (OpiskeluoikeudetRequest.) set-id-query)]
    (extract-opiskeluoikeus-data (.opiskeluoikeudet service request))))

(defn get-from-virta-by-pid [person-id virta-fetcher]
  (log/debug "fetching VIRTA by pid: " person-id)
  (virta-fetcher #(.setHenkilotunnus % person-id)))

(defn get-from-virta-by-oid [oid virta-fetcher]
  (log/debug "fetching VIRTA by oid: " oid)
  (virta-fetcher #(.setKansallinenOppijanumero % oid)))
