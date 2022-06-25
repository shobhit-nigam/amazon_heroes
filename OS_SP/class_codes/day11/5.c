#include<stdio.h>
#include<unistd.h>
#include<signal.h>

void handler()
{
	printf("invincible");
	return;
}

void main()
{
	int i = 0;
	int pid = getpid();
	signal(SIGINT, SIG_IGN);
	signal(SIGTERM, handler);
	for (i=0; 1; i++)
	{
		printf("%d running since %d seconds\n", pid, i);
		sleep(1);
	}
	return;
}
