#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

void main()
{
	int fd = 11;
	static char buf[20];
	fd = open("snapchat", O_RDONLY);
	read(fd, buf, 8);
	printf("read data is %s\n", buf);
	close(fd);
	return;
}
