# freedom
Example web application with clojure for a repl-driven development demonstration.
And some capabilities of clojure applications in terms of web micro-services:
- Writing an always up-to-date swagger definition yaml with [swagger1st](https://github.com/zalando-stups/swagger1st)

```yaml
paths:
  /users:
    get:
      summary: get users
      description: |
        get all user ids
      tags:
        - users
        - awesome
      # Hint: here we reference the actual Clojure function to call when this request comes in
      operationId: freedom.handlers/get-all-users
```

- Writing SQL queries with (surprise) SQL syntax - [hugsql](https://github.com/layerware/hugsql)

```sql
-- :name get-all-user-ids :? :*
-- :doc Get all user ids we have
SELECT id FROM users
```

- Migrating the database with ragtime

```sql
ALTER TABLE users ADD COLUMN age INTEGER DEFAULT NULL
```

- Wiring the dependencies of the application and managing the state - [mount](https://github.com/tolitius/mount)

```clojure
(mount/start)
```

- Getting the synergie of all those things together using REPL and the text editor of your choice


## Prerequisites
- Java 8
- Leiningen [installed](https://leiningen.org/#install)
- Local postgresql `user: postgres, password: postgres` with a database `freedom` freshly created and available
- Being able to run this repository without huge stacktraces with `lein run` or at least `lein repl`
- Preferably - your favorite text editor and the way to connect to a REPL from it (can assist with emacs/spacemacs setup for now, approach me beforehand if you have any questions about cursive/vim/lighttable)

## Plan
- Starting it locally
- Adding functionality to all the sides (migrating the database, adding new API endpoints, modifying internal logic) 
- Building an artifact, deploying to playground cluster


## Running freedom

```
lein run
```

or

```
lein repl
```

```clojure
(-main)
; ... checking things
(mount/stop)
```

Navigate to [the UI](http://localhost:3001/ui/) to get the Swagger UI for discovery.
