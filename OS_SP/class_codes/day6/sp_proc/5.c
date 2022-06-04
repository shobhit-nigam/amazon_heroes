#include<stdio.h>
#include<unistd.h>

int main()
{
	int i=100;
	printf("i am %d\n", getpid());
	printf("and my parent is %d\n", getppid());
	i = fork();
	printf("i = %d\n", i);
	printf("after fork i am %d\n", getpid());
	printf("after fork and my parent is %d\n", getppid());
	sleep(10);
	return 0;
}
