#include<stdio.h>
#include<unistd.h>

void main()
{
	int pd[2];
	int i=0;
	// creates a pipe, and passes the descriptors to pd
	pipe(pd);
	//pd[0] --> read 
	//pd[1] --> write
	i = fork();
	if (i==0)
	{
		static char buf[20];
		printf("child reads\n");
		read(pd[0], buf, 7);
		printf("read dara is %s\n", buf);
	}
	else
	{
		printf("parent writes\n");
		sleep(3);
		write(pd[1], "good morning", 12);
	}
	return;
}
