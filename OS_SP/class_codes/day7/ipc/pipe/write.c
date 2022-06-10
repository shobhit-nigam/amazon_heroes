#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

void main()
{
	int fd=10;
	printf("write process is openeing the file for writing\n");
	sleep(2);
	fd = open("insta", O_WRONLY);
	printf("write process is going to write\n");
	sleep(2);
	write(fd, "it's complicated", 16);
	printf("write process has written\n");
	close(fd);
	return;
}
