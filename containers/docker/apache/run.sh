#!/bin/bash
# First build image with $ docker build -t arvo_apache .
# Then run apache, example $ ./run.sh $(ipconfig getifaddr en0)

MY_IP=$1
exec docker run --rm -it \
  --add-host=appserver:$MY_IP \
  -p 443:443 \
  -p 80:80 \
  avopfi_apache
