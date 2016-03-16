(ns avopfi.integration.arvo
  (:require
    [config.core :refer [env]]
    [buddy.sign.jws :as jws]
    [clj-http.client :as client]))

(defn clean-opiskeluoikeus-data
  [{:keys [kieli tyyppi]
    {oppilaitos-id :id} :oppilaitos
    {koulutus-id :id} :koulutus
    {kunta-id :id} :kunta}]
  {
   :oppilaitos oppilaitos-id
   :koulutus koulutus-id
   :kunta kunta-id
   :tyyppi tyyppi
   :kieli kieli})

(defn generate-questionnaire-credentials!
  "Generate Arvo questionnaire credentials with given data"
  [opiskeluoikeus-data]
  (let [resp
        (:body
          (client/post
            (:arvo-api-url env)
            {:form-params (clean-opiskeluoikeus-data opiskeluoikeus-data)
             :headers {:Authorization
                       (str "Bearer " (jws/sign {:userid 1} (:arvo-jwt-secret env)))}
             :content-type   :json
             :socket-timeout 2000
             :conn-timeout   1000}))]
    ;;(:hash resp)
    "THLJWM"))