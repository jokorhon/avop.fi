#Dockerfile for centos7 + apache
FROM centos:centos7
MAINTAINER Oscar Perez  <oscar.perez@gofore.com>
LABEL Vendor="CentOS"
LABEL License=GPLv2
LABEL Version=2.4.6-31

RUN yum -y update && yum clean all

#Installing apache
#BUG: No possible to use AUFS storage driver. See: https://github.com/docker/docker/issues/6980
RUN yum -y install httpd && yum clean all

EXPOSE 8080

# Simple startup script to avoid some issues observed with container restart
ADD run-httpd.sh /run-httpd.sh
RUN chmod -v +x /run-httpd.sh

CMD ["/run-httpd.sh"]

