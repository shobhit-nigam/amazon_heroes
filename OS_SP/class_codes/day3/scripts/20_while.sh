#!/bin/bash

read stat

while [ $stat != "bye" ]
do
	echo "you said \"$stat\""
	read stat
	echo "------"
done

echo "outside the loop"
