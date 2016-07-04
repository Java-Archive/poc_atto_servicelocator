#!/bin/bash
cd "$(dirname "$0")/.." #set current dir as working dir

for server in "$@"
do
   echo  "starting <$server>"
   vagrant up $server --provision 
#   vagrant provision $server
done

exit 0
