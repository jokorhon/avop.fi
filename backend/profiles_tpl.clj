{:profiles/dev  {:env {
   :is-dev true
   :virta-tunnus "avopfi"
   :virta-jarjestelma "avopfi"
   :virta-salaisuus "salaisuus"
   :virta-url "http://virtawstesti.csc.fi/luku/opiskelijatiedot.wsdl"
   :opintopolku-base-url "https://testi.virkailija.opintopolku.fi/"
   :database-url "jdbc:postgresql://192.168.99.100/avopfi?user=avopfi&password=avopfi"}}
 :profiles/test {:env {
 	:database-url "jdbc:postgresql://192.168.99.100/avopfi_test?user=avopfi&password=avopfi"}}}
