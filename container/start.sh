#!/bin/sh
AVOPFIPATH=/home/mostro/projects/avop.fi
docker rm -f -v avop-temp
docker run \
  -v $AVOPFIPATH/ansible:/ansible:ro \
  -w /ansible \
  --name=avop-temp \
  ansible/centos7-ansible:stable \
  ansible-playbook -i hosts/dev.txt setup.yml --vault-password-file=vault.password
&& docker commit avop-temp avop
docker rm -f -v avop-temp
