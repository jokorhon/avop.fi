(ns avopfi.integration.arvo
  (:require
    [config.core :refer [env]]
    [avopfi.consts :refer :all]
    [buddy.sign.jws :as jws]
    [java-time :refer [as local-date]]
    [clojure.core.match :refer [match]]
    [clj-http.client :as client]))

(defn build-kyselykerran-nimi 
  "For spec of this string, see 
  https://goo.gl/GCsQN0"
  [opiskeluoikeustyyppi vuosi]
  (if (nil? opiskeluoikeustyyppi)
      nil
      (str
        (match opiskeluoikeustyyppi
          amk-alempi-tyyppi "AMK" 
          amk-ylempi-tyyppi "YAMK"
          :else "") vuosi)
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
        auth-header (str "Bearer " (jws/sign {:userid 1} (:arvo-jwt-secret env)))
        resp
        (:body
          (client/post
            (:arvo-api-url env)
            {:form-params json-data
             :headers {:Authorization auth-header}
             :content-type   :json
             :socket-timeout 2000
             :conn-timeout   1000}))]
    ;;(:hash resp)
    "THLJWM"))
