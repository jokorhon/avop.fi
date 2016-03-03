(ns avopfi.integration.shibbo-utils
  (:import (javax.servlet ServletRequest)))

(defn ^:private deprefixize [p m] 
  (into {} 
        (map #(vector 
               (clojure.string/replace (first %) p "") (second %)) m)))

(defn ^:private get-ajp-attributes
  "Extracts attributes from servlet-request. 
  Recommended way to pass Shibboleth env vars to JVM is by 
  AJP protocol."
  [names req]
  (let [^ServletRequest request (:servlet-request req)]
      (if (some? request)
        (into {} 
              (map #(let [val (.getAttribute request %)]
                      [%
                       (if (some? val) (cast String val) "")]) names)) nil)))

(defn ^:private get-header-attributes 
  "Extracts attributes from HTTP headers.
  Insecure header attributes populated by Shibboleth NativeSP
  could be used in development/test."
  [names request prefix]
  (let [prefixed (map #(str prefix %) names)]
    (into {} 
          (filter 
           #((complement clojure.string/blank?) (last %))
           (deprefixize prefix (select-keys (:headers request) prefixed))))))

(defn get-attributes [names request env]  
  (do 
    (if (:is-dev env) 
      (get-header-attributes names request "shib-")
      (get-ajp-attributes names request))))
