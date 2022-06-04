#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

void main()
{
	int fda=0, fdb=0;
	printf("hey, i am %d and I am opening food.txt\n", getpid());
	fda = open("food.txt", O_RDONLY);
	printf("fd of food.txt is %d\n", fda);
	sleep(25);
	printf("hey, i am %d and I am opening drink.txt\n", getpid());
	fdb = open("drink.txt", O_RDONLY);
	printf("fd of drink.txt is %d\n", fdb);
	sleep(10);
	close(fda);	close(fdb);
	return;
}

