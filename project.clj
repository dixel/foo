(defproject foo "0.1.0-SNAPSHOT"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.6.2"]
                 [org.zalando/swagger1st "0.25.0"]
                 [ring/ring-jetty-adapter "1.6.2"]
                 [org.postgresql/postgresql "42.1.4"]
                 [com.layerware/hugsql "0.4.7"]
                 [ragtime "0.7.2"]
                 [org.clojure/java.jdbc "0.7.1"]
                 [com.taoensso/timbre "4.10.0"]
                 [environ "1.1.0"]
                 [com.fzakaria/slf4j-timbre "0.3.7"]
                 [mount "0.1.11"]]

  :ring {:handler foo.api/app}
  :main foo.core

  :profiles {:dev {:plugins [[lein-ring "0.12.0"]
                             [lein-environ "1.1.0"]]
                   :aliases {"migrate" ["run" "-m" "freedom.db/migrate"]}
                   :env {:pgsql-uri "//localhost:5432/freedom"
                         :pgsql-user "postgres"
                         :pgsql-password "postgres"
                         :debug "true"}}})
