(ns avopfi.test.integration.opintopolku-test
  (:use
    [clojure.test :refer :all]
    [avopfi.integration.opintopolku])
  (:require [environ.core :refer [env]]))

(deftest ^:integration op-integrations
  (testing "Gets some kind of stuff"
    (is (not (nil? (get-education-data "321902"))))))
