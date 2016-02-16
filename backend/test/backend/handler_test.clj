(ns backend.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [backend.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/api"))]
      (is (= (:status response) 200))
      (is (not= (:body response) ""))))
  
  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
                                        
                                        
                                        
