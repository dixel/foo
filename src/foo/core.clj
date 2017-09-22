(ns foo.core
  (:require [foo.api :refer [api]]
            [mount.core :as mount]
            [taoensso.timbre :as log]))

(defn -main [& args]
  (log/merge-config! {:level :info})
  (mount/start))
