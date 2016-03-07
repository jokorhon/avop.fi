(ns avopfi.middleware
  (:require [avopfi.layout :refer [*app-context* error-page]]
            [avopfi.auth.backend :refer [shibbo-backend authz-backend]]
            [clojure.tools.logging :as log]
            [config.core :refer [env]]
            [ring-ttl-session.core :refer [ttl-memory-store]]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.middleware.anti-forgery :refer [wrap-anti-forgery]]
            [ring.middleware.format :refer [wrap-restful-format]]
            [avopfi.config :refer [defaults]]            
            [buddy.auth.middleware :refer [wrap-authentication wrap-authorization]]
            [buddy.auth.backends.token :refer [token-backend]]
            [buddy.auth.accessrules :refer [restrict]]
            [buddy.auth :refer [authenticated?]])
  (:import [javax.servlet ServletContext]))

(defn wrap-context [handler]
  (fn [request]
    (binding [*app-context*
              (if-let [context (:servlet-context request)]
                ;; If we're not inside a servlet environment
                ;; (for example when using mock requests), then
                ;; .getContextPath might not exist
                (try (.getContextPath ^ServletContext context)
                     (catch IllegalArgumentException _ context))
                ;; if the context is not specified in the request
                ;; we check if one has been specified in the environment
                ;; instead
                (:app-context env))]
      (handler request))))

(defn wrap-internal-error [handler]
  (fn [req]
    (try
      (handler req)
      (catch Throwable t
        (log/error t)
        (error-page {:status 500
                     :title "Error 500"
                     :message "Server error."})))))

(defn wrap-csrf [handler]
  (wrap-anti-forgery
    handler
    {:error-response
     (error-page
       {:status 403
        :title "Invalid anti-forgery token"})}))

(defn wrap-formats [handler]
  (let [wrapped (wrap-restful-format
                  handler
                  {:formats [:json-kw :transit-json :transit-msgpack]})]
    (fn [request]
      ;; disable wrap-formats for websockets
      ;; since they're not compatible with this middleware
      ((if (:websocket? request) handler wrapped) request))))

(defn on-403 [request response]
  {:status  403
   :headers {"Content-Type" "application/json"}
   :body   {:status 403
            :message  (str "Access to " (:uri request) " is forbidden")}})

(defn wrap-restricted [handler]
  (restrict handler {:handler authenticated?
                     :on-error on-403}))

(defn authenticate [request token]
  (if (= token "secret") "valid" nil))

(defn wrap-base [handler]
  (-> ((:middleware defaults) handler)
      wrap-formats
      (wrap-authentication (shibbo-backend)
                           (token-backend {:authfn authenticate}))
      (wrap-authorization (authz-backend))
      (wrap-defaults
        (-> site-defaults
            (assoc-in [:security :anti-forgery] false)
            (assoc-in  [:session :store] (ttl-memory-store (* 60 30)))))
      wrap-context
      wrap-internal-error))
