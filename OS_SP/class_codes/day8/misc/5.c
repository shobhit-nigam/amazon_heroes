#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

void main()
{
	int fd = 10;	static char buf[20];
	fd = open("hello.txt", O_RDONLY);
	perror("open: ");
	read(fd, buf, 6);
	perror("read: ");
	printf("read data is %s\n", buf);
	return;
}
