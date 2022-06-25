#include<stdio.h>
#include<unistd.h>

void main()
{
	printf("namaste ");
	fflush(stdout);
	fork();
	printf("hello ");
	return;
}
