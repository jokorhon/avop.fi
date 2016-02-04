FROM centos:centos7

MAINTAINER Oscar Perez  <oscar.perez@gofore.com>

# Enable Extra Packages for Enterprise Linux (EPEL) for CentOS
RUN yum -y update && yum clean all
RUN yum -y install sudo epel-release && yum clean all

# Install Node.js and npm
RUN yum install -y nodejs npm

WORKDIR workspace
# Install app dependencies
RUN npm install

EXPOSE  8080

