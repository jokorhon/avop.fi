avop.fi ansible
===============

Ansible-playbookit ja roolit, joilla konfiguroidaan avop.fi -palvelimet
ja haluttaessa paikallinen kehitysympäristö. Testattu CentOS 7:llä, toimii
melko suurella todennäköisyydellä myös RHEL7:llä.

Testattu Ansible 2.0:lla, saattaa toimia myös 1.9.4:llä.

Roolit
------

* *apache*

    Asentaa ja konfiguroi Apache HTTP Serverin ja autentikaatioon käytettävän
    Shibbolethin (Apache-moduulin ja Shibboleth-daemonin).
* *backend*

    Asentaa ja konfiguroi Tomcatin, johon sijoitetaan backend-sovellus. Lisäksi
    Tomcatia varten luodaan systemd:n unit-tiedosto.
* *postgresql*

    Asentaa ja konfiguroi PostgreSQL:n
* *deploy-frontend* ja *deploy-backend*

    Frontendin ja backendin deployt. Tarvitsevat ../frontend- ja
    ../backend-hakemistot ja niihin oikeaa sisältöä (onnistuneet buildit)

Playbookit
----------

  * *setup.yml*

    Asentaa Apachen, Tomcatin ja PostgreSQL:n
  * *deploy-frontend.yml*

    Ajaa deploy-frontend -roolin
  * *deploy-backend.yml*

    Ajaa deploy-backend -roolin

Käyttö
------

HOX, tarvitset vault-salasanatiedoston (vault.password), jossa on salattujen
muuttujatiedostojen salausavain.

### Ajaminen

Ajaminen paikallisesti (esim. kehittäjän virtuaalikoneessa)

    # tarvitsee ajaa vain kerran (tai kun middleware-asetuksiin on tehty muutoksia)
    ansible-playbook -i hosts/dev.txt --vault-password-file=vault.password setup.yml
    # deployt, tarvitsee ajaa kun buildeja
    ansible-playbook -i hosts/dev.txt --vault-password-file=vault.password deploy-frontend.yml
    ansible-playbook -i hosts/dev.txt --vault-password-file=vault.password deploy-backend.yml

Muissa ympäristöissä korvaa inventory (hosts/dev.txt) oikean ympäristön inventoryllä.

### Uuden ympäristön lisääminen

1. Tee uusi inventory (hosts/[ympäristö].txt)
  Tarvitset seuraavat ryhmät
  
      [backend]
      [frontend]
      [postgresql]

  Lisäksi on kätevää tehdä all-ryhmä, jolla voi määritellä kaikille koneille
  yhteisiä muuttujia, varsinkin **environment_id** on pakollinen!

      [all:children]
      postgresql
      frontend
      backend
      [all:vars]
      environment_id=<ympäristö>

2. Tee uudelle ympäristölle ympäristökohtaiset muuttujat
   (vars/environment/[ympäristö].yml ja [ympäristö]_vault.yml)
   _vault.yml pitää luoda näin

   `ansible-vault create --vault-password-file=vault.password vars/environment/[ympäristö]_vault.yml`
   
3. Määrittele ympäristökohtaiset muuttujat

  vars/environment/[ympäristö].yml:
  
      ---
      apache:
        server_name: "palvelimen ulos näkyvä nimi"
        certificate: "foo.cert" # tätä etsitään /etc/pki/tls/certs/-hakemistosta
        certificate_key: "foo.key" # tätä etsitään /etc/pki/tls/private/-hakemistosta
        appserver: "localhost" # mistä osoitteesta Apache löytää backendin (ProxyPass)
      postgresql_avop_user: "{{ vault_postgresql_avop_user }}"
      postgresql_avop_password: "{{ vault_postgresql_avop_password }}"
      
  vault_-alkuiset määritellään [ympäristö]_vault.yml:ssä.
