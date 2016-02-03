FROM centos:centos7
MAINTAINER O

# Install required packages
RUN yum -y install python-pip

RUN pip install -U docker-compose

ENV DOCKER_HOST unix:///tmp/docker.sock

WORKDIR /src
CMD ["/bin/bash"]
