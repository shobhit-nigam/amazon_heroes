#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

int main()
{
	int fda =0;
	static char buf[100] = "system programing";
	fda = open("drink.txt", O_WRONLY);
	write(1, "RIP KK", 6);
	printf("written\n");
	close(fda);
	return 0;
}

