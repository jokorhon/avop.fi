(defproject backend "1.0.0-SNAPSHOT"
  :description "avop.fi front"
  :url "https://avop.fi"
  :min-lein-version "2.0.0"
  :source-paths      ["src/clojure"]
  :java-source-paths ["src/java"]
  :javac-options     ["-target" "1.8" "-source" "1.8"]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]                 
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-json "0.4.0"]
                 [org.clojure/java.data "0.1.1"]                 
                 [liberator "0.13"]
                 [korma "0.4.0"]
                 [org.postgresql/postgresql "9.4.1207"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler backend.handler/app
         :nrepl {:start? true :port 59258}}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
