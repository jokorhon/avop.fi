(ns avopfi.integration.arvo
  (:require
    [config.core :refer [env]]
    [buddy.sign.jws :as jws]
    [clj-http.client :as client]))

(defn clean-opiskeluoikeus-data [data]
  data)

(defn generate-questionnaire-credentials!
  "Generate Arvo questionnaire credentials with given data"
  [opiskeluoikeus-data]
  (let [resp
        (:body
          (client/post
            (str (:arvo-api-url env) "public/luo-vastaajatunnus")
            {:form-params (clean-opiskeluoikeus-data opiskeluoikeus-data)
             :headers {:Authorization
                       (str "Bearer " (jws/sign {:userid 1} "secret"))}
             :content-type   :json
             :socket-timeout 2000
             :conn-timeout   1000}))]
    ;;(:hash resp)
    "THLJWM"))