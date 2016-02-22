(ns avopfi.integration.shibbo-utils-test
  (:import javax.servlet.ServletRequest)
  (:require [clojure.test :refer :all]
            [avopfi.integration.shibbo-utils :refer :all]))

(def test-data {"foo" "foo value" "bar" "bar value"})

(defn prefixize [p m] (into {} (map #(vector (str p (first %)) (second %)) m)))
(defn get-keys-as-strings [data] (map #(name %) (keys test-data)))

(deftest shibbo-attributes
  (testing "get shibboleth attributes from headers"
    (let [env {:is-dev true}
          request {:headers (prefixize "shib-" test-data)}
          names (keys test-data)
          attribs (get-attributes names request env)]
      (is (= attribs test-data))))
  
  (testing "get shibboleth attributes from request attributes"
    (let [env {}
          request {:servlet-request 
                   (reify ServletRequest 
                     (getAttribute [this name]
                       (cond (= name "foo") (test-data "foo")
                             (= name "bar") (test-data "bar"))))}
          names (keys test-data)
          attribs (get-attributes names request env)]
      (is (= attribs test-data)))))
