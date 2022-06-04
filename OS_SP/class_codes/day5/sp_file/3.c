#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

void main()
{
	int fda;
	//sys call will fail if hello.txt does not exist
	fda = open("food.txt", O_RDONLY);
	printf("fd of hello.txt is %d\n", fda);
	return;
}

