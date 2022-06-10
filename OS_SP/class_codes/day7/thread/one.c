#include<stdio.h>
#include<unistd.h>

void taskA()
{
	int i = 3;
	for (i=3; i>0; i--)
	{
		printf("taskA will end in %d seconds\n", i);
		sleep(1);
	}
	return;
}
void taskB()
{
	int i = 6;
	for (i=6; i>0; i--)
	{
		printf("taskB will end in %d seconds\n", i);
		sleep(1);
	}
	return;
}



void main()
{
	int i = 9;
	taskA();
	taskB();
	for (i=9; i>0; i--)
	{
		printf("main task will end in %d seconds\n", i);
		sleep(1);
	}
		
	return;
}
