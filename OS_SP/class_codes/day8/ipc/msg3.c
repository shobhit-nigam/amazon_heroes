#include<stdio.h>
#include<unistd.h>
#include<sys/ipc.h>
#include<sys/msg.h>
#include<string.h>

struct msgbuf
{
	long mtype;
	char mtext[144];
};

void main()
{
	int key=100, id=100;
	key = ftok("/usr/bin", 8);
	struct msgbuf mb;
	id = msgget(key, IPC_CREAT|0666);
	
	mb.mtype = 21;
	strcpy(mb.mtext, "not your birthday");
	
	msgsnd(id, &mb, sizeof(struct msgbuf), 0);
	perror("sending ");
	return;
}
