#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

int main()
{
	int fda=0, fdb=0;
	fda = open("hello.txt", O_WRONLY);
	printf("opened hello.txt with fd = %d\n", fda);
	close(1);
	fdb = open("hi.txt", O_WRONLY);
	printf("opened hi.txt with fd = %d\n", fdb);
		// same as write(1, ... , ...)
	sleep(5);
	close(fdb);
	close(fda);
	return 0;
}

