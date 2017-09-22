-- :name get-all-user-ids :? :*
-- :doc Get all user ids we have
SELECT id FROM users

-- :name get-user :? :*
-- :doc Get user information
SELECT * FROM users WHERE id = :id

-- :name add-user :! :n
-- :doc Add new user to the database
INSERT INTO users (id, name, age) VALUES (:id, :name, :age)
