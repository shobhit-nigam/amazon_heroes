#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

void main()
{
	int fd=10;
	static char buf[20];
	printf("read process is opening the file for reading\n");
	sleep(2);
	fd = open("insta", O_RDONLY);
	printf("read process is going to read\n");
	sleep(2);
	read(fd, buf, 7);
	printf("read data is --> %s\n", buf);
	close(fd);
	return;
}
