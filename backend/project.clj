(defproject backend "1.0.0-SNAPSHOT"
  :description "avop.fi front"
  :url "https://avop.fi"
  :min-lein-version "2.0.0"
  :source-paths      ["src/clojure"]
  :java-source-paths ["src/java"]
  :javac-options     ["-target" "1.8" "-source" "1.8"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.4.0"]
                 [ring/ring-devel "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-json "0.4.0"]
                 [rmarianski/ring-jetty-servlet-adapter "0.0.4"]
                 [org.clojure/java.data "0.1.1"] 
                 [korma "0.4.0"]
                 [environ "1.0.2"]
                 [migratus "0.8.11"]
                 [clojure.java-time "0.2.0"]
                 [clj-http "2.0.1"]
                 [org.postgresql/postgresql "9.4.1207"]]
  :plugins [
    [lein-environ "1.0.2"]
    [migratus-lein "0.1.7"]
    [lein-ring "0.9.7"]]
  :ring {:handler avopfi.handler/app
         :port 3000
         :nrepl {:start? true :port 59258}})
