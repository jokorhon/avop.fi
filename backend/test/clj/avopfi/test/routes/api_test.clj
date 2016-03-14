(ns avopfi.test.routes.api-test
  (:use
    [clojure.test :refer :all]
    [avopfi.routes.api])
  (:require [config.core :refer [env]]
            [avopfi.integration.opintopolku :as op]
            [avopfi.integration.virta :as virta]))


(def study-rights-fixture [{:avain "FOO" :myontaja {:koodi "123"}}])
(def attainments-fixture [
                          {:opiskeluoikeusAvain "FOO" :laji "2" :sisaltyvyys [] :laajuus {:opintopiste 100}}
                          {:opiskeluoikeusAvain "FOO" :laji "2" :sisaltyvyys [] :laajuus {:opintopiste 90}}
                          ])

(deftest study-credit-checks
  (testing "Checking VIRTA study credits when there's enough credits"
    (is (has-enough-study-credits? attainments-fixture (first study-rights-fixture))))
  (testing "Checking VIRTA study credits when there's not enough credits"
    (is (not (has-enough-study-credits? (rest attainments-fixture) (first study-rights-fixture))))))


;(deftest filtering-rights
;  (testing "Filters rights and converts to json structure"
;    (with-redefs [has-organization? (fn [x y] (= "yliopisto.fi" x))
;                  virta/select-active-timespan (constantly {:loppuPvm nil})
;                  virta/conclude-study-type (constantly 0)
;                  op/extract-metadata (constantly "metadata")
;                  op/get-municipality-data (constantly nil)
;                  op/get-education-data (constantly nil)
;                  op/get-school-data (constantly nil)]
;      (is (nil? (println
;                  (filter-rights study-rights-fixture attainments-fixture "yliopisto.fi"))))
;      (is true))))
