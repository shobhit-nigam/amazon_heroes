#include<stdio.h>
#include<unistd.h>

void main()
{
	int pid = 0;
	pid = getpid();
	printf("hey, i am %d\n", pid);
	printf("hello world\n");
}
