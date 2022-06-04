#include<stdio.h>
#include<unistd.h>

int main()
{
	int i=100;
	printf("i am the actuall process, %d\n", getpid());
	printf("----------");
	i = fork();
	if (i==0)
	{
		printf("i am child & ret value is = %d\n", i);
		printf("after fork i am %d\n", getpid());
		printf("after fork and my parent is %d\n", getppid());
		printf("----------");
	i = fork();
	}
	else
	{
		sleep(10);
		printf("i am the parent & ret value is = %d\n", i);
		printf("after fork i am %d\n", getpid());
		printf("after fork and my parent is %d\n", getppid());
		printf("----------");
	i = fork();

	}
	return 0;
}
