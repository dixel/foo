(ns foo.core
  (:require [foo.api :refer [api]]
            [mount.core :as mount]))

(defn -main [& args]
  (mount/start))
