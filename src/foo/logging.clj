(ns foo.logging
  (:require [mount.core :refer [defstate]]
            [taoensso.timbre :as log]))

(defstate logging
  :start (log/merge-config! {:level :info}))
