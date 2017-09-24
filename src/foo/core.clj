(ns foo.core
  (:require [foo
             [api :refer [api]]
             [logging :refer [logging]]]
            [taoensso.timbre :as log]
            [mount.core :as mount]))

(defn -main [& args]
  (log/info "starting foo application")
  (mount/start))
