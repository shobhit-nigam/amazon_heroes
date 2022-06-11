#include<stdio.h>
#include<unistd.h>
#include<sys/ipc.h>
#include<sys/msg.h>
#include<string.h>

void main()
{
	msgctl(4, IPC_RMID, 0);
	return;
}

