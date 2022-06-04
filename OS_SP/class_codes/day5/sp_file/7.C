#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

int main()
{
	int fda =0;
	static char buf[100];
	fda = open("food.txt", O_RDONLY);
	read(fda, buf, 5);
	sleep(2);
	printf("read data is %s\n", buf);
	close(fda);
	return 0;
}

