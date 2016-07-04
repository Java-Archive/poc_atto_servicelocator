# AttoService POC

#Clone the repo
This repository does contain sumbmodules. To clone this repo and its submodules use the command <br>
`git clone --recursive` <br>
 To checkout the submodules on an already cloned repo use <br>
`git submodule update --init --recursive`

#Testing

# Vagrant infrastructure

## Prerequisites
You need to have the following software installed on your machine
* [Vagrant](https://www.vagrantup.com/downloads.html) at least version 1.8.4
* [Virtualbox](https://www.virtualbox.org/wiki/Downloads)

## VMs created
|name|address|description|
|----|-------|-----------|
|elk |10.1.1.2:5601|Machine with an lek stack installed to get the logs from all running nodes|
|nexus|10.1.1.3|A nexus repository in which the artifacts can be deployed|
|atto-servicelocator|10.1.1.5|The servicelocator-service|
|atto-server|10.1.1.6|the server|



## Vagrant commands
Open a shell of your liking and go to the `integration` directory.
Vagrant commands must always be called in the directory where the `Vagrantfile` is located.

 |command|description|
 |------------------|--------|
 |`vagrant up`| boot up all VMs defined in the `Vagrantfile`|
 |`vagrant up --provision`| boot up all VMs defined in the `Vagrantfile` and enforces the provisioner to run|
 |`vagrant up <name>` | boot up VM <name> defined in the `Vagrantfile`|
 |`vagrant up <name> --provision` | boot up VM <name> defined in the `Vagrantfile` and enforces the provisioner to run|
 |`vagrant suspend` | will stop all VMs  defined in the `Vagrantfile`|
 |`vagrant suspend <name>` | will stop VM <name> defined in the `Vagrantfile`|
 |`vagrant destroy` | will delete all VMs  defined in the `Vagrantfile`|
 |`vagrant destroy <name>` | will delete VM <name> defined in the `Vagrantfile`|
 |`vagrant ssh <name>` | will open an ssh session to the VM <name> defined in the `Vagrantfile`|

#
## Build Cycle

* On the `install` target ov maven the elk VM and the nexus will be started and installed if necessary.
* With the profile `deploy-local-nexus` active in the `deploy` lifecycle of maven the the build jars will be deployed to the nexus.
* In the `pre-integration-test` phase the needed VMs will be started and installed if necessary.
* In the `integration-test` phase all integration test will be run
* In the `post-integration-test` all test VMs will be suspended.



