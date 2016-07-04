#!/bin/bash
cd "$(dirname "$0")/.." #set parent dir as working dir



vagrant status atto-servicelocator --machine-readable  | grep "state,running"

if [ $? -eq 0 ]
	then 
		echo "atto-servicelocator is allready running";
		vagrant provision atto-servicelocator
	else vagrant up atto-servicelocator --provision
fi

vagrant status atto-server --machine-readable  | grep "state,running"

if [ $? -eq 0 ]
	then 
		echo "atto-server is allready running";
		vagrant provision atto-server
	else vagrant up atto-server --provision
fi
exit 0

