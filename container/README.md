# avopfi frontend

## Prerequisites

You will need virtualbox and Vagrant installed in your computer. Tested with Vagrant 1.8.1 version

Download Vagrant from its own webpage since the version from linux package managers tends to be outdated:

    https://www.vagrantup.com/downloads.html

The image used for this project does not have vbox guest additions installed due to a bug, see: 

   https://github.com/CentOS/sig-cloud-instance-build/issues/27

You can install it via plugin with the following command:

   vagrant plugin install vagrant-vbguest

## Running

  * vagrant up - starts up the virtual machine, defines external IP to access the guest machine and sets synced folders
  * vagrant provision  - runs ansible provisioning configuring according to dev environment
  * vagrant ssh - access the guest centos 7 virtual machine
    
## Using the application

Inside the virtual machine there is the following synced folder (home/vagrant/sync/scripts)  with deploy scripts
  * sh ./deployfrontend.sh - deploys the frontend to the apache instance running in the guest machine
  * sh ./deploybackend.sh - deploys the backend to the tomcat instance running in the guest machine

Please note that packaging and compilation occurs in the host machine hence valid packages must exist before using the above scripts. Compilation and related tasks must be done in the host machine whereas the main task of the guest machine is to perform the deployment
 

## License

Copyright @ 2016 CSC

