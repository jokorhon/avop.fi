(ns avopfi.integration.opintopolku
  (:require 
   [clojure.string :as str]
   [config.core :refer [env]]
   [clj-http.client :as client]))

(def rest-path "koodisto-service/rest/codeelement/latest/")

(defn build-url [code code-type]
  (str (:opintopolku-base-url env) rest-path code-type "_" code))

(defn get-code-data! [code code-type]
  (:body (client/get
          (build-url code code-type)
          {:as :json :socket-timeout 2000 :conn-timeout 1000})))

(defn get-school-data [code]
  (get-code-data! code "oppilaitosnumero"))

(defn get-municipality-data [code]
  (get-code-data! code "kunta"))

(defn get-education-data [code]
  (get-code-data! code "koulutus"))

(defn ^:deprecated get-school-code-by-domain
  "Koodisto service mapping from HAKA home-organization domain name 
  to VIRTA's oppilaitos code"
  [domain]
  (if (nil? domain)
    nil
    (-> 
     (get-code-data! (str/replace domain "." "")
                     "oppilaitosdomain")
     :metadata first :nimi)))

(defn extract-metadata [body] 
  (into {} 
        (map 
         #(vector (str/lower-case (:kieli %)) (:nimi %)) 
         (:metadata body))))














