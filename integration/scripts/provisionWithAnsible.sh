#!/bin/bash
ssh vagrant@10.1.1.2 -i /vagrant/.vagrant/machines/ansible/virtualbox/private_key   <<'ENDSSH'
#commands to run on remote host
ansible-playbook --limit nexus /vagrant/ansible/playbook.yml 
ENDSSH
exit 0

