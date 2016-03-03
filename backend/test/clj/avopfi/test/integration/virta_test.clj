(ns avopfi.test.integration.virta-test
  (:use
    [midje.sweet]
    [avopfi.integration.virta])
  (:require [config.core :refer [env]]))

(fact "Timespan having no loppuPvm is selected"
      (let [timespans [{:loppuPvm nil}
                       {:loppuPvm {:year 2015 :month 12 :day 1}}]]
        (select-active-timespan timespans)
        => {:loppuPvm nil}))