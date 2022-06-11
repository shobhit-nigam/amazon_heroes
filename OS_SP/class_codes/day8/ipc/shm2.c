#include<stdio.h>
#include<unistd.h>
#include<sys/shm.h>
#include<sys/ipc.h>
#include<string.h>

void main()
{
	int key=0, id=0;
	char *ptr;
	key = ftok("/usr/bin", 10);
	id = shmget(key, 100, IPC_CREAT|0777);
	ptr = shmat(id, 0, 0);
	perror("attach ");
	printf("read data is %s\n", ptr);
	shmdt(ptr);
	return;
}

