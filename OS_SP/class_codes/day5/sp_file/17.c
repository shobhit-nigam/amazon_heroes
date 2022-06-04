#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

int main()
{
	int fda =0, fdb=0;
	static char buf[100];
	fda = open("food.txt", O_RDONLY);
	printf("fda = %d\n", fda);
	read(fda, buf, 4);
	printf("read data is %s\n", buf);
	sleep(2);

	fdb= dup(fda);
	printf("fdb = %d\n", fdb);
	read(fdb, buf, 5);
	printf("read data is %s\n", buf);
	close(fda);
	return 0;
}

