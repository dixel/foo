(ns foo.handlers
  (:require [foo
             [storage :refer [database]]
             [storage :as storage]]
            [ring.util.response :as r]
            [taoensso.timbre :as log]))

(defn get-all-users
  "Generates a greeting message and returns it."
  [request]
  ; extract parameter from request and generate message
  (let [users (storage/get-all-user-ids database)]
    ; form ring response - json serialization will be done by s1st
    (-> (r/response {:users users})
        (r/content-type "application/json")
        (r/header "Access-Control-Allow-Origin" "*"))))

(defn add-user
  "add a new user to the database"
  [request]
  (let [name (get-in request [:parameters :query :name])
        age (get-in request [:parameters :query :age])]
    (log/infof "add-user: %s" {:name name
                               :age age})
    (storage/add-user database {:id (rand-int 10000)
                                :age age
                                :name name})
    (-> (r/response {:message "created"})
        (r/content-type "application/json")
        (r/header "Access-Control-Allow-Origin" "*"))))

(defn get-user
  "get user information"
  [request]
  (let [id (read-string (get-in request [:parameters :path :id]))
        user-info (storage/get-user database {:id id})]
    (log/infof "getting info for request: " (:parameters request))
    (-> (r/response {:user user-info})
        (r/content-type "application/json")
        (r/header "Access-Control-Allow-Origin" "*"))))
