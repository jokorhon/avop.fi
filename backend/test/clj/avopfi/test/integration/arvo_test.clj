(ns avopfi.test.integration.arvo-test
  (:use
    [clojure.test :refer :all]
    [avopfi.integration.arvo])
  (:require
    [environ.core :refer [env]]
    [clj-http.client :as client]))

(def fixture
  {
   :koulutus   {:id 321}
   :kunta      {:id 675}
   :oppilaitos {:id 123}
   :tyyppi     0
   :kieli      "fi"})

(deftest cleanup
  (testing "cleaning of data"
    (is (=
          (clean-opiskeluoikeus-data fixture)
          {:koulutus   (-> fixture :koulutus :id)
           :kunta      (-> fixture :kunta :id)
           :oppilaitos (-> fixture :oppilaitos :id)
           :tyyppi     (:tyyppi fixture)
           :kieli      (:kieli fixture)}))))

(deftest cleanup-fail
  (testing "cleaning of empty data"
    (let [cleaned (clean-opiskeluoikeus-data {})]
      (is (every? nil? (vals cleaned))))))

(deftest arvo-call
  (testing "Call to Arvo is proper"
    (with-redefs
      [client/post
       (fn [url & [req]]
         (do
           (is
             (re-matches #"Bearer ([A-Za-z0-9-_=.]+)"
                         (-> req :headers :Authorization)))
           {:body {:foo ""}}))]
      (is (= "THLJWM"
             (generate-questionnaire-credentials!
               {:data "foo"}))))))
