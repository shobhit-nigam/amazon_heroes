#include<stdio.h>
#include<unistd.h>

void main()
{
	int pd[2];
	int i=0;
	pipe(pd);
	i = fork();
	if (i==0)
	{
		printf("child writes\n");
		write(pd[1], "have a good morning", 19);
		printf("child has written\n");
	}
	else
	{
		static char buf[20];
		printf("parent reads\n");
		read(pd[0], buf, 6);
		printf("read data is %s\n", buf);
	}
	return;
}
