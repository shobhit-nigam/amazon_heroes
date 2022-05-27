#!/bin/bash

data=1

while [ $data -lt 5 ]
do
	echo "hello"
	echo "The value is $data"
	echo "-----"
	data=$(($data + 1))
done

echo "outside the loop"
