(ns avopfi.routes.public
  (:require
    [buddy.auth :refer [throw-unauthorized]]
    [avopfi.db.core :as db]
    [compojure.core :refer :all]
    [ring.util.http-response :refer :all]))

(defn get-visitors [study-right-id]
  (db/get-visitors-by-srid {:study_right_id study-right-id}))

(defroutes public-routes
  (context "/public" []
   (GET "/students/:study-right-id{.{0,100}}" [study-right-id :as {i :identity}]
     (if (not (= "valid" i))
       (throw-unauthorized)
       (get-visitors study-right-id)))))