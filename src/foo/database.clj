(ns foo.database
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.jdbc.migrations :as migrations]
            [ragtime.repl :as ragtime-repl]
            [environ.core :refer [env]]
            [hugsql.core :as hugsql]
            [mount.core :refer [defstate]]
            [taoensso.timbre :as log]))

(def db
  {:classname "postgresql.Driver"
   :subprotocol "postgresql"
   :subname (env :pgsql-uri)
   :user (env :pgsql-user)
   :table (env :pgsql-table)
   :password (env :pgsql-password)})

(def migration-config
  {:datastore (jdbc/sql-database db)
   :migrations (jdbc/load-resources "db/migrations")})

(defn migrate []
  (ragtime-repl/migrate migration-config))

(defstate database
  :start (do
           (log/info "running migrations...")
           (migrate)
           (log/info "migrations done")
           db))
