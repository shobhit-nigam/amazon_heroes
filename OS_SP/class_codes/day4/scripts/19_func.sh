#!/bin/bash

# create/define a function


function greet() {
	echo "good afternoon $1"
	echo "hope you enjoy your work at $2"
	echo "bye bye $1, see you after lunch"
}

greet Varsha amazon

echo "\$1 = $1"
echo "\$2 = $2"
