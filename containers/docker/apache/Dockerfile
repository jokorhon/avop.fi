#Dockerfile for centos7 + apache
FROM centos:centos7
MAINTAINER Oscar Perez  <oscar.perez@gofore.com>

RUN yum -y update && yum clean all

#Installing apache and ssl deps
#BUG: No possible to use AUFS storage driver. See: https://github.com/docker/docker/issues/6980
RUN yum -y install \
	httpd \
	mod_ssl \
	openssl && yum clean all

RUN yum-config-manager --add-repo http://download.opensuse.org/repositories/security://shibboleth/CentOS_7/security:shibboleth.repo
RUN yum -y install shibboleth.x86_64 && yum clean all

RUN yum -y install wget && cd /etc/shibboleth && wget -O haka_testi_2015.crt https://confluence.csc.fi/download/attachments/31195585/haka_testi_2015_sha2.crt?version=1 && wget https://haka.funet.fi/metadata/haka_test_metadata_signed.xml

# Shibboleth conf
COPY shibboleth2.xml /etc/shibboleth/shibboleth2.xml
COPY attribute-map.xml /etc/shibboleth/attribute-map.xml
COPY attribute-policy.xml /etc/shibboleth/attribute-policy.xml

# Apache conf
COPY avopfi.conf /etc/httpd/conf.d/avopfi.conf

# Cert
COPY local.avop.fi.cert /etc/pki/tls/certs/local.avop.fi.cert
COPY local.avop.fi.key /etc/pki/tls/certs/local.avop.fi.key

EXPOSE 80
EXPOSE 443

# Simple startup script to avoid some issues observed with container restart
ADD run-httpd.sh /run-httpd.sh
RUN chmod -v +x /run-httpd.sh

CMD ["/run-httpd.sh"]

