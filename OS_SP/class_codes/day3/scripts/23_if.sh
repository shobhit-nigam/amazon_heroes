#!/bin/bash

echo "hey, what is your age?"
read age

if [ $age -lt 18 ]; then
	echo "you are not old enough"
elif [ $age -ge 60 -a $age -lt 75 ]; then
	echo "we welcome you with a discount of 10%"
	echo "double vaccinated ?"
	echo "booster dosage?"
elif [ $age -ge 75 ]; then
	echo "you get a discount of 20%"
else
	echo "we welcome you"
	# logic of your program 
fi

echo "ending the script"
