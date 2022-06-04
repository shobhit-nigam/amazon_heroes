#include<stdio.h>
#include<unistd.h>

int main()
{
	printf("i am %d\n", getpid());
	printf("and my parent is %d\n", getppid());
	fork();
	printf("after fork i am %d\n", getpid());
	printf("after fork and my parent is %d\n", getppid());
	sleep(10);
	return 0;
}
