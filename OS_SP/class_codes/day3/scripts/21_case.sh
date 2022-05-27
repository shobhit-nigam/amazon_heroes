#!/bin/bash

echo "enter two numbers"

read x
read y

echo "enter your choice: "
echo "1 for addition, 2 for subtraction"

read choice

case $choice in
	1)res=$(($x + $y))
		;;
	2)res=$(($x - $y))
		;;
	*)res=$(($x + $y))
		echo "wrong choice entered, so adding both"
		;;
esac

echo "result is $res"

