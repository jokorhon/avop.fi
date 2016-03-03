# avopfi


## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.
Running PostgreSQL is needed to host data.

[1]: https://github.com/technomancy/leiningen

## Running

Before running application needs configuration. Create `profiles.clj` with proper database configuration. 
Use `profiles_tpl.clj` as a starting point.

After database if configured the database schema can be migrated by running:

    lein run migrate
 
To start a web server for the application, run:

    lein run

You can also start application from REPL by running first `lein repl` and then `(start)` in the REPL.

## License

Copyright © 2016 CSC
