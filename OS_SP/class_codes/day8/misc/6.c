#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

void main()
{
	int fd = 10;
	fd = open("hello.txt", O_RDONLY);
	perror("open: ");
	write(fd, "hey", 3);
	perror("write: ");
	return;
}
