(ns backend.opintopolku
  (:require 
   [environ.core :refer [env]]
   [clj-http.client :as client]))

(def rest-path "koodisto-service/rest/codeelement/latest/")

(defn build-url [code code-type]
  (str (:opintopolku-base-url env) rest-path code-type "_" code))

(defn get-code-data [code code-type]
  (client/get (build-url code code-type) {:as :json}))

(defn get-oppilaitos-data [code]
  (get-code-data code "oppilaitosnumero"))

(defn get-kunta-data [code]
  (get-code-data code "kunta"))

(defn get-koulutus-data [code]
  (get-code-data code "koulutus"))

(defn get-oppilaitos-code-by-domain [domain]
  (get-code-data (clojure.string/replace domain "." "") "oppilaitosdomain"))

