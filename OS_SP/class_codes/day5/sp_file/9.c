#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

int main()
{
	int fda =0;
	static char buf[100] = "\nmiss you\n";
	fda = open("drink.txt", O_WRONLY|O_APPEND);
	write(fda, buf, 10);
	printf("written\n");
	close(fda);
	return 0;
}

