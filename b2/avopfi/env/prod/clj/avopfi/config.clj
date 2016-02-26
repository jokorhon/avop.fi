(ns avopfi.config
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[avopfi started successfully]=-"))
   :middleware identity})
