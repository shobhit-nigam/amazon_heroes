#!/bin/bash

old_IFS="$IFS"
IFS=":"

read name power

echo "i am $name and my power is $power"

IFS=$old_IFS
