#!/bin/bash
# Check README.md on how to use
MY_IP=$1
exec docker run --rm -it \
  --add-host=appserver:$MY_IP \
  -p 443:443 \
  -p 80:80 \
  avopfi_apache
