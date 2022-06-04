#include<stdio.h>
#include<unistd.h>

int main()
{
	int i=100;
	i = fork();
	printf("hello\n");
	if (i==0)
	{
		printf("i am child\n");
		sleep(10);
		printf("i am child with pid = %d\n", getpid());
		printf("i am child & my parent is %d\n", getppid());
		printf("----------\n");
	}
	else
	{
		printf("i am the parent\n");
		sleep(12);
		printf("i am parent with pid = %d\n", getpid());
		printf("i am parent & my parent is %d\n", getppid());
		printf("----------\n");

	}
	return 0;
}
