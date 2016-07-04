#!/bin/bash
cd "$(dirname "$0")/.." #set parent dir as working dir


vagrant status nexus --machine-readable  | grep "nexus,state,running"

if [ $? -eq 0 ]
	then echo "nexus is allready running"
	else vagrant up nexus
fi

exit 0

