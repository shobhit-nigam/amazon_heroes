#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

void main()
{
	int fd = 11;
	fd = open("snapchat", O_WRONLY);
	write(fd, "hello world", 11);
	close(fd);
	return;
}
