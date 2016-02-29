#!/bin/sh
AVOPFIPATH=/home/mostro/projects/avop.fi/ansible
docker rm -f -v apache-temp
docker run \
  -v $AVOPFIPATH/ansible:/ansible:ro \
  -w /ansible \
  --name=apache-temp \
  ansible/centos7-ansible:stable \
  ansible-playbook -i hosts/dev.txt setup.yml --vault-password-file=vault.password
&& docker commit apache-temp apache
docker rm -f -v apache-temp
