#!/bin/bash

i=-5
until [ $i -gt 0 ]
do
	echo "value is $i"
	i=$(( i-1 ))
done
