#include<stdio.h>
#include<unistd.h>
#include<sys/wait.h>

int main()
{
	int i=100;
	i = fork();
	if (i==0)
	{
		printf("i am child with pid = %d\n", getpid());
		sleep(10);
		printf("i am child & my parent is %d\n", getppid());
	}
	else
	{
		printf("i am parent with pid = %d\n", getpid());
		sleep(5);
		printf("i am parent & my parent is %d\n", getppid());
		wait(NULL);
		printf("parent's last line, it will exit now\n");
	}
	return 0;
}
