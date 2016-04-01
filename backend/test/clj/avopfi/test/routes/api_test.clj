(ns avopfi.test.routes.api-test
  (:require [config.core :refer [env]]
            [avopfi.consts :refer :all]
            [clojure.test :refer :all]
            [avopfi.routes.api :refer :all]
            [avopfi.integration.opintopolku :as op]
            [avopfi.integration.arvo :as arvo]
            [avopfi.db.core :as db]
            [avopfi.test.fixtures :refer [opiskeluoikeus-data-fixture]]
            [avopfi.integration.virta :as virta]
            [avopfi.db.migrations :as migrations]))

(def study-rights-fixture [{:avain "FOO"
                            :myontaja {:koodi "123"}
                            :laajuus {:opintopiste 235}
                            :tyyppi 1
                            }])
(def attainments-fixture [
                          {:opiskeluoikeusAvain "FOO" :laji "2" :sisaltyvyys [] :laajuus {:opintopiste 100}}
                          {:opiskeluoikeusAvain "FOO" :laji "2" :sisaltyvyys [] :laajuus {:opintopiste 90}}
                          ])

(deftest study-credit-checks
  (testing "Checking VIRTA study credits when there's enough credits"
    (with-redefs [opintopisteet-amk-alempi-min-pct 80]
      (is (has-enough-opintosuoritus? attainments-fixture (first study-rights-fixture)))))
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

;;(use-fixtures :once (fn [f] (migrations/migrate ["migrate"]) (f)))

(deftest process-registrations 
  (testing "registration works"
    (with-redefs
      ;;do not hit Arvo nor db atm
      [
        arvo/generate-questionnaire-credentials! (constantly "FOO")
        db/get-visitor-by-srid (constantly nil)
        db/create-visitor! (constantly nil)
      ]
      (let [attribs {:body-params {:opiskeluoikeus_id "avopOa1"}
        :session {:opiskeluoikeudet-data [opiskeluoikeus-data-fixture]}}]
        (is (= (:kysely_url (:body (process-registration attribs))) "http://avopvastaustest.csc.fi/FOO"))))))













