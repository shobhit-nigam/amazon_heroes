#include<stdio.h>
#include<unistd.h>
#include<signal.h>

void func()
{
	printf("talk to my hand\n");
	return;
}

int main()
{
	int i=0;	int pid=0;
	signal(SIGTERM, func);
	pid = getpid();
	for (i=0; 1; i++)
	{
		printf("%d running since %d seconds\n", pid, i);
		sleep(1);
	}
	return 0;
}
