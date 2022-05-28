#!/bin/bash
read filename
if [ -e $filename ]
then
	echo "------"
	exec ls
	exec ./21.sh
fi
