#!/bin/bash

# Make sure we're not confused by old, incompletely-shutdown httpd
# context after restarting the container.  httpd won't start correctly
# if it thinks it is already running.
rm -rf /run/httpd/* /tmp/httpd*

exec /usr/sbin/apachectl -DFOREGROUND > /dev/null 2>&1 &

# Shibboleth daemon
# exec /bin/systemctl start shibd.service
exec /usr/sbin/shibd > /dev/null 2>&1 &

exec bash