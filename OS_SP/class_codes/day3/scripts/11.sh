#!/bin/bash

echo "hey, what is your age?"
read age
if [ $age -lt 18 ]
then
	echo "you are not old enough"
else
	echo "we welo=come you"
fi
