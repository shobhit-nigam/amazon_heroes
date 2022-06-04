#include<stdio.h>
#include<unistd.h>

int main()
{
	int i=0;	int pid=0;
	pid = getpid();
	for (i=0; 1; i++)
	{
		printf("%d running since %d seconds\n", pid, i);
		sleep(1);
	}
	return 0;
}
