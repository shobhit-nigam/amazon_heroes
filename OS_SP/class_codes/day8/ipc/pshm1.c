#include<stdio.h>
#include<fcntl.h>
#include<string.h>
#include<unistd.h>
#include<sys/mman.h>

void main()
{
	int fd=0;
	char *ptr;

	fd = shm_open("/bin", O_CREAT|O_RDWR, 0666);
	ftruncate(fd, 200);
	ptr = mmap(0, 200, PROT_WRITE, MAP_SHARED, fd, 0);
	memset(ptr, 0, 200);
	strcpy(ptr, "valar morghulis");
	munmap(ptr, 200);
	close(fd);
}
