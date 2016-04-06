(ns avopfi.integration.arvo
  (:require
    [config.core :refer [env]]
    [avopfi.consts :refer :all]
    [buddy.sign.jws :as jws]
    [java-time :refer [as local-date]]
    [slingshot.slingshot :refer [try+ throw+]]
    [clojure.core.match :refer [match]]
    [clojure.tools.logging :as log]
    [clj-http.client :as client]))

(defn build-kyselykerran-nimi 
  "For spec of this string, see 
  https://goo.gl/GCsQN0"
  [opiskeluoikeustyyppi vuosi]
  (if (nil? opiskeluoikeustyyppi)
      nil
      (str "AUTOMAATTI AVOP-"
        (match opiskeluoikeustyyppi
          amk-alempi-tyyppi "AMK" 
          amk-ylempi-tyyppi "YAMK"
          :else "") " " vuosi)
      ))

(defn clean-opiskeluoikeus-data
  [{:keys [kieli koulutusmuoto opiskeluoikeustyyppi laajuus]
    {oppilaitos-id :id} :oppilaitos
    {koulutus-id :id} :koulutus
    {kunta-id :id} :kunta}]
  {
   :oppilaitos oppilaitos-id
   :koulutus   koulutus-id
   :kunta      kunta-id
   :kieli      kieli
   :koulutusmuoto (match koulutusmuoto
                    0 "paivaopiskelu"
                    1 "monimuoto"
                    :else nil)
   :opiskeluoikeustyyppi opiskeluoikeustyyppi
   :laajuus laajuus
   :kyselykerran_nimi (build-kyselykerran-nimi opiskeluoikeustyyppi 
    (as (local-date) :year))
   })

(defn generate-questionnaire-credentials!
  "Generate Arvo questionnaire credentials with given data"
  [opiskeluoikeus-data]
  (let [json-data (clean-opiskeluoikeus-data opiskeluoikeus-data)
        auth-header (str "Bearer " 
                         (jws/sign {:caller "avopfi"} (:arvo-jwt-secret env)))]
    (println json-data)
    (try+ 
     (let [resp (client/post
                 (:arvo-api-url env)
                 {
                  :debug (:is-dev env)
                  :form-params json-data
                  :headers {:Authorization auth-header}
                  :as :json
                  :socket-timeout 2000
                  :conn-timeout 1000})]       
       (if (nil? (-> resp :body :hash)) 
         (throw+ resp)
         (-> resp :body :hash)))
     (catch [:status 403] {:keys [request-time headers body]}
       (log/warn "403" request-time headers))
     (catch Object _
       (log/error (:throwable &throw-context) "unexpected error")
       (throw+)))))
