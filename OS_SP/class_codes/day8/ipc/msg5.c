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
	struct msgbuf mb;
	key = ftok("/home", 100);
	id = msgget(key, IPC_CREAT|0666);

	printf("write the message & id after the beep\n");
	scanf("%s", mb.mtext);
	scanf("%ld", &mb.mtype);

	msgsnd(id, &mb, sizeof(struct msgbuf), 0);
	printf("message sent\n");
}

