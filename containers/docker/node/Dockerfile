FROM centos:centos7

MAINTAINER Oscar Perez  <oscar.perez@gofore.com>

# Enable Extra Packages for Enterprise Linux (EPEL) for CentOS
RUN yum -y update && yum clean all
RUN yum -y install sudo epel-release && yum clean all

# Install Node.js and npm
RUN yum install -y nodejs npm

# Install app dependencies
COPY ../../frontend/package.json /src/package.json
RUN cd /src; npm install

# Bundle app source
COPY ../../frontend /src

EXPOSE  8080
CMD ["node", "/src/index.js"]
