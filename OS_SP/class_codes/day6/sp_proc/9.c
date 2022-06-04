#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

int main()
{
	int i=100, fda=0;
	fda = open("lunch.txt", O_RDONLY);
	i = fork();
	if (i==0)
	{
		static char buf[10];
		printf("i am child and will sleep for 5 seconds\n");
		sleep(5);
		read(fda, buf, 4);
		printf("child reads --> %s\n", buf);
	}
	else
	{
		static char buf[10];
		printf("i am parent with pid = %d\n", getpid());
		sleep(1);
		read(fda, buf, 4);
		printf("parent reads --> %s\n", buf);
	}
	return 0;
}
