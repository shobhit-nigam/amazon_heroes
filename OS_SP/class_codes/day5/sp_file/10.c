#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

int main()
{
	int fda=0;	int ret=0;
	static char buf[20];
	fda = open("lunch.txt", O_RDONLY);
	while(1)	
	{
		ret = read(fda, buf, 3);
		printf("read data is %s and ret=%d\n", buf, ret);
		sleep(2);
	}
	close(fda);
	return 0;
}

