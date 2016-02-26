{:dev
 {:dependencies
  [[midje "1.8.3"]
   [javax.servlet/servlet-api "2.5"]
   [ring/ring-mock "0.3.0"]]
  :plugins [[lein-midje "3.2"]]
  :env
  {
   :is-dev true
   :virta-tunnus "avopfi"
   :virta-jarjestelma "avopfi"
   :virta-salaisuus "salaisuus"
   :db-driver "org.postgresql.Driver"
   :db-name "avopfi"
   :db-host "192.168.99.100"
   :db-port "5432"
   :db-user "avopfi"
   :db-pass "avopfi"
   :virta-url "http://virtawstesti.csc.fi/luku/opiskelijatiedot.wsdl"
   :opintopolku-base-url "https://testi.virkailija.opintopolku.fi/"
   }}}










