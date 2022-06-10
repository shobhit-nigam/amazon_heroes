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
		static char buf[20];
		printf("child reads\n");
		read(pd[0], buf, 6);
		printf("read data is %s\n", buf);

	}
	else
	{
		printf("parent writes\n");
		sleep(3);
		write(pd[1], "new", 3);
	}
	return;
}
