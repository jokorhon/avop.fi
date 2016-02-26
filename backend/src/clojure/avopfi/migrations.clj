(ns avopfi.migrations

  (:require [migratus.core :as migratus]))

(def config {:store                :database
             :migration-dir        "migrations/"
             :migration-table-name "migrations"
             :db {:classname   "org.h2.Driver"
                  :subprotocol "h2"

                  :subname     "site.db"}})

  db (postgres
      {:db (:db-name env)
       :user (:db-user env)
       :password (:db-user env)
       :host (:db-host env)
       :port (:db-port env)}))

(defn migrate []
  (migratus/migrate config))

(defn rollback []
  (migratus/rollback config))
