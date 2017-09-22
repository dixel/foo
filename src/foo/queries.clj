(ns foo.queries
  (:require [hugsql.core :as hugsql]))

(hugsql/def-db-fns "db/queries.sql")
