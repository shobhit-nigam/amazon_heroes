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
	shmctl(id, IPC_RMID, 0);
	return;
}

