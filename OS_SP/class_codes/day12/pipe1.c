#include<stdio.h>
#include<unistd.h>

void main()
{
	int pd[2];	int x=0;
	static char buf[20];
	pipe(pd);
	x = fork();
	if (x==0)
	{
		printf("child writes after 4 secs\n");	sleep(4);
		write(pd[1], "valar dohaeris", 14);
		sleep(2);
	}
	else
	{
		printf("parent reads\n");
		read(pd[0], buf, 7);
		printf("parent read --> %s\n", buf);
		read(pd[0], buf, 4);
		printf("parent read --> %s\n", buf);
	}
	sleep(4);
	return;
}
