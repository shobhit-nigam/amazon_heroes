#include<stdio.h>
#include<unistd.h>
#include<pthread.h>

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
	int i = 9;	
	for (i=9; i>0; i--)
	{
		printf("taskB will end in %d seconds\n", i);
		sleep(1);
	}
	return;
}

void main()
{
	int i = 6;
	pthread_t ta, tb;

	pthread_create(&ta, NULL, (void *)  taskA, NULL);
	pthread_create(&tb, NULL, (void *) taskB, NULL);
	for (i=6; i>0; i--)
	{
		printf("main task will end in %d seconds\n", i);
		sleep(1);
	}
	pthread_join(tb, NULL);	
	return;
}
