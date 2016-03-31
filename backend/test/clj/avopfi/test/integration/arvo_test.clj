(ns avopfi.test.integration.arvo-test
  (:use
    [clojure.test :refer :all]
    [avopfi.integration.arvo])
  (:require
    [clj-http.fake :as fake]
    [java-time :refer [as local-date]]
    [environ.core :refer [env]]
    [clj-http.client :as client]))

(def fixture
  {
   :koulutus   {:id 321}
   :kunta      {:id 675}
   :oppilaitos {:id 123}
   :koulutusmuoto 0
   :opiskeluoikeustyyppi "1"
   :laajuus 260
   :kieli      "fi"})

(deftest cleanup
  (testing "cleaning of data"
    (is (=
          (clean-opiskeluoikeus-data fixture)
          {:koulutus   (-> fixture :koulutus :id)
           :kunta      (-> fixture :kunta :id)
           :oppilaitos (-> fixture :oppilaitos :id)
           :koulutusmuoto "paivaopiskelu"
           :laajuus 260
           :kieli      (:kieli fixture)
           :opiskeluoikeustyyppi "1"
           :kyselykerran_nimi (str "AMK" (as (local-date) :year))
           }))))

(deftest cleanup-fail
  (testing "cleaning of empty data"
    (let [cleaned (clean-opiskeluoikeus-data {})]
      (is (every? nil? (vals cleaned))))))

(def arvo-api-endpoint
  "http://avoptest.csc.fi/api/public/luo-vastaajatunnus")
(def arvo-hash "THLJWM")

(deftest succesful-arvo-call
  (testing "Call to Arvo is proper"
    (fake/with-fake-routes
      {
       arvo-api-endpoint
       (fn [req]
        (do (is
          (re-matches #"Bearer ([A-Za-z0-9-_=.]+)"
            (-> req :headers :Authorization)))
        {:status 200 :headers {} :body (str "{\"hash\": \"" arvo-hash "\"}")}))
      }        
      (is (= arvo-hash (generate-questionnaire-credentials!
       fixture))))))

(deftest erroneous-arvo-call
  (testing "Call to Arvo throws exception when wrong body"
    (fake/with-fake-routes
      {
       arvo-api-endpoint
       (fn [req]
        {:status 200 :headers {} :body "{}"})
      }        
      (is (thrown? clojure.lang.ExceptionInfo (generate-questionnaire-credentials!
       fixture))))))

