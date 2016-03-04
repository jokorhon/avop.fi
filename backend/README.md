# avopfi backend

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

### Running uberjar

    java -Dis-dev="true" -Dvirta-tunnus="avopfi" \
    -Dvirta-jarjestelma="avopfi" -Dvirta-salaisuus="salaisuus" \
    -Dvirta-url="http://virtawstesti.csc.fi/luku/opiskelijatiedot.wsdl" \
    -Dopintopolku-base-url="https://testi.virkailija.opintopolku.fi/" \
    -Ddatabase-url="jdbc:postgresql://192.168.99.100/avopfi?user=avopfi&password=avopfi" \
    -jar avopfi.jar


## Development tips

If the real apache Shibboleth NativeSP proxy is not used, there's a 
possibility to spoof Shibboleth auth headers in dev mode with browser 
plugin.

| Header | Example value |
| ---- |---- |
| shib-shib-session-id | whatever |
| shib-national-identification-number | 010280-123A |
| shib-home-organization | yliopisto.fi |    


## License

Copyright © 2016 CSC
