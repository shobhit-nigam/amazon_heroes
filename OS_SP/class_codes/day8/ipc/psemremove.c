#include<stdio.h>
#include<semaphore.h>
#include<fcntl.h>
#include<unistd.h>

void main()
{
	sem_t *sem;
	sem = sem_open("/root", O_CREAT|O_RDWR, 0666, 1);
	sem_unlink("/root");
	return;
}
