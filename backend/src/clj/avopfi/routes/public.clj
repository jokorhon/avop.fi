(ns avopfi.routes.public
  (:require
    [buddy.auth :refer [throw-unauthorized]]
    [avopfi.db.core :as db]
    [compojure.core :refer :all]
    [ring.util.http-response :refer :all]))

(defn get-visitor [identity study-right-id]
  (if (not (= "valid" identity))
    (throw-unauthorized)
    (ok (db/get-visitor-by-srid {:opiskeluoikeus-id study-right-id}))))

(defroutes public-routes
  (context "/public" []
   (GET "/students/:opiskeluoikeus-id{.{0,100}}" [opiskeluoikeus-id :as {i :identity}]
     (get-visitor i opiskeluoikeus-id))))