#!/bin/bash
cd "$(dirname "$0")/.." #set parent dir as working dir


vagrant status atto-server --machine-readable  | grep "state,running"

if [ $? -eq 0 ]
	then vagrant suspend atto-server
	else echo "atto-server is alöready down";
fi

vagrant status atto-servicelocator --machine-readable  | grep "state,running"

if [ $? -eq 0 ]
	then 
		vagrant suspend atto-servicelocator
	else 
	echo "atto-servicelocator is allready running";
fi
exit 0

