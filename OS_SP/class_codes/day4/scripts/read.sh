#!/bin/bash

while read l 
do
	echo $l
	sleep 2
done < $1
