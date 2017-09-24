(ns foo.api
  (:require [foo.storage :refer [database]]
            [foo.logging :refer [logging]]
            [io.sarnowski.swagger1st.core :as s1st]
            [io.sarnowski.swagger1st.util.security :as security]
            [mount.core :refer [defstate]]
            [ring.adapter.jetty :as jetty]
            [taoensso.timbre :as log]))

(def app
  (-> (s1st/context :yaml-cp "api/foo-api.yaml")
      (s1st/discoverer)
      (s1st/mapper)
      (s1st/parser)
      (s1st/executor)))

(defn start-server []
  (jetty/run-jetty app {:port 3001
                        :join? false}))

(defstate api
  :start (do
           (log/infof "starting the API...")
           (let [server (start-server)]
             (log/info "API server started")
             server))
  :stop (.stop api))
