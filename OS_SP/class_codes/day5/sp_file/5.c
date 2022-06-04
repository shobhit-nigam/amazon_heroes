#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

void main()
{
	int fda =0;
	printf("hey, i am %d and I am opening food.txt\n", getpid());
	fda = open("food.txt", O_RDONLY);
	printf("fd of hello.txt is %d\n", fda);
	sleep(20);
	close(fda);
	return;
}

