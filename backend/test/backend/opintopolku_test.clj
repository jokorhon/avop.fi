(ns backend.opintopolku-test
  (:use 
   [midje.sweet]
   [backend.opintopolku]) 
  (:require [environ.core :refer [env]]))

(facts "about OP integrations" :it
       (fact "Gets proper kind of stuff"
         (get-koulutus-data "321902") => truthy))
