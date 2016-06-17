# rapidpm-vagrant
## What is this for
This repo is used to create an automated infrastructure for integration test of RapidPM project.
To achive this virtual machines are created and provisionend in a private network. Then all the required software is installed so test can run against this infrastructure.

## How this works
First to be able to work on the versions you currently develop there is an vm started with a local nexus running on it.
In this repo you can deploy your artifacts without the need of committing your code. 
This is usefull if you work on server and client code. The server get deployed and the virtual infrastructure installs it on an vm to test against.

The virtual machines are defined in the `Vagrantfile ` in the root folder of this repository.
With this file vagrant can start the VMs based on a vagrant box (ubuntu as of right now). 

To install the needed software onto the VM ansible is used.
Ansible will be called from within vagrant and knows what to install.

Which software ansible installs is handeld in the playbook `ansible/playbook.yml`. 



## Prerequsites

* Vagrant installed 
* Ansible installed

## Usage

### Usefull commands
#### Disclaymer
All vagrant commands must be executed in the root folder of this repo.

#### Synopsis

`vagrand <command> [name_of_vm]`
if `[name_of_vm]` is given, the command as listed below will only be executed on the VM with this name. Some commands can only be executed on one VM `ssh` for example.
#### Vagrant commands

|command|description|
|:-------------|-----|
|`up`|  This command will start the VMs described in the `Vagrantfile`.  If the VM is not existing at the time of execution Vagrant will install a new one and run the ansible playbook on it|
|`suspend`|Will suspend the VM|
|`destroy`|Will shutdown and delete the VM|
|`provision`|Will run the provision again. This is usefull if you only want to update somethin or test a change in the playbook|
|`status`|Will print the status of all VMs in the `Vagrantfile`|


## Current VMs
| Name | IP | installed artifact|
|---------| -------|-----|
|nexus  | 10.1.1.3| nexus|
|atto-server| 10.1.1.5 |server of the attoservice poc|
|atto-servicelocator|10.1.1.6|servicelocator of the atto service poc|


