(ns avopfi.test.integration.arvo-test
  (:use
    [clojure.test :refer :all]
    [avopfi.integration.arvo])
  (:require
    [environ.core :refer [env]]
    [clj-http.client :as client]))

(deftest arvo-call
  (testing "Call to Arvo is proper"
    (with-redefs [client/post (fn [url & [req]]
                                (do
                                  (is
                                    (re-matches #"Bearer ([A-Za-z0-9-_=.]+)"
                                                (-> req :headers :Authorization)))
                                  {:body {:foo ""}}))]
      (is (= "THLJWM" (generate-questionnaire-credentials! {:data "foo"}))))))
