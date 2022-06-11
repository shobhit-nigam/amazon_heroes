#include<stdio.h>
#include<fcntl.h>
#include<sys/ipc.h>
#include<sys/msg.h>
#include<string.h>

struct msgbuf
{
	long mtype;
	char mtext[140];
};

void main()
{
	int key=0, id=0;
	long num;
	struct msgbuf mb;
	key = ftok("/home", 100);
	id = msgget(key, IPC_CREAT|0666);

	printf("which mtype do you want to read \n");
	scanf("%ld", &num);

	msgrcv(id, &mb, sizeof(struct msgbuf), num, IPC_NOWAIT);
	printf("message rcvd is %s\n", mb.mtext);
}

