#!/bin/bash
read data
if [ "$data" = "haan" ]
then
	echo "running a new script"
	sleep 1
	exec /home/nigam/Desktop/captain/day4/scripts/25.sh
else
	echo "not launching any other file"
fi
