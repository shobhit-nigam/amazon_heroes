#!/bin/bash
read filename
if [ -e $filename ]
then
	echo "------"
	exec ./21.sh
fi
