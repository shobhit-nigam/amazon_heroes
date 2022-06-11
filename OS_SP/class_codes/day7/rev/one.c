#include<stdio.h>
#include<unistd.h>

void main()
{	
	int pd[2], i=33;
	pipe(pd);
	i = fork();
	if (i==0)
	{
		static char buf[20];
		printf("it's the child\n");
		read(pd[0], buf, 6);
		printf("read data is %s\n", buf);
	}
	else
	{
		printf("it's the parent\n");
		sleep(5);
		write(pd[1], "hello world", 11);
		printf("parent has written\n");
	}
	return;
}
