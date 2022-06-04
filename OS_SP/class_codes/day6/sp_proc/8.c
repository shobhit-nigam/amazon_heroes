#include<stdio.h>
#include<unistd.h>

int main()
{
	int i=100;
	i = fork();
	if (i==0)
	{
		printf("i am child with pid = %d\n", getpid());
		sleep(20);
		printf("i am child & my parent is %d\n", getppid());
		printf("----------\n");
	}
	else
	{
		printf("i am parent with pid = %d\n", getpid());
		sleep(25);
		printf("i am parent & my parent is %d\n", getppid());
		printf("----------\n");

	}
	return 0;
}
