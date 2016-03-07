# AVOP.fi backend

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.
Running PostgreSQL is needed to host data.

[1]: https://github.com/technomancy/leiningen

## Running

Before running application needs configuration. Create `profiles.clj` with proper database configuration. 
Use `profiles_tpl.clj` as a starting point.
  
To start a web server for the application, run:

    lein run

You can also start application from REPL by running first `lein repl` and then `(start)` in the REPL.

**Note:** database migrations are executed in ring handler's init at startup.

### Running uberjar

    java -Dis-dev="true" -Dvirta-tunnus="avopfi" \
    -Dvirta-jarjestelma="avopfi" -Dvirta-salaisuus="salaisuus" \
    -Dvirta-url="http://virtawstesti.csc.fi/luku/opiskelijatiedot.wsdl" \
    -Dopintopolku-base-url="https://testi.virkailija.opintopolku.fi/" \
    -Ddatabase-url="jdbc:postgresql://192.168.99.100/avopfi?user=avopfi&password=avopfi" \
    -jar avopfi.jar

## Testing

Run unit tests

    $ lein test
    
Run integration tests
    
    $ lein test :integration
     
Integration tests are marked with `^:integration` metadata.

## About authentication

Production setup is using Apache + Shibboleth NativeSP, uberwar deployed 
to Tomcat and AJP protocol between Apache and Tomcat. 

If the real Apache Shibboleth NativeSP proxy is not used, there's a 
possibility to spoof Shibboleth auth headers in dev mode with browser 
plugin.

| Header | Example value |
| ---- | ---- |
| shib-national-identification-number | 010280-123A |
| shib-home-organization | yliopisto.fi |  



## License

Copyright © 2016 CSC
