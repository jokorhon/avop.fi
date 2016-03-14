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
    (is (has-enough-opintosuoritus? attainments-fixture (first study-rights-fixture))))
  (testing "Checking VIRTA study credits when there's not enough credits"
    (is (not (has-enough-opintosuoritus? (rest attainments-fixture) (first study-rights-fixture))))))

(deftest filtering-rights
  (testing "Filters rights and converts to json structure"
    (with-redefs [has-organization? (fn [x y] (= "yliopisto.fi" x))
                  virta/select-active-timespan (constantly {:loppuPvm nil})
                  virta/conclude-study-type (constantly 0)
                  op/extract-metadata (constantly {:fi "suomeksi" :sv "ruotsiksi"})
                  op/get-kunta-data (constantly nil)
                  op/get-koulutus-data (constantly nil)
                  op/get-oppilaitos-data (constantly nil)]
      (let [results (filter-oikeudet study-rights-fixture attainments-fixture "yliopisto.fi")]
        (is (= (:id results) (-> study-rights-fixture :avain)))
        (is (= (:type results) (-> study-rights-fixture :avain)))
        ))))
