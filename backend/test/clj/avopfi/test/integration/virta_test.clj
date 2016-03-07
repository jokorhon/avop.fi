(ns avopfi.test.integration.virta-test
  (:use
    [clojure.test :refer :all]
    [avopfi.integration.virta])
  (:require [config.core :refer [env]]))

(deftest timespans
   (testing "Timespan having no loppuPvm is selected"
     (let [timespans [{:loppuPvm nil}
                      {:loppuPvm {:year 2015 :month 12 :day 1}}]]
       (is (= (select-active-timespan timespans) {:loppuPvm nil})))))