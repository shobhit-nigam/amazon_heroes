#include<stdio.h>
#include<unistd.h>

int main()
{
	printf("i am %d\n", getpid());
	printf("and my parent is %d\n", getppid());
	return 0;
}
