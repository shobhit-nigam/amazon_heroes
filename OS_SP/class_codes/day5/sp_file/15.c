#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>

int main()
{
	int fda =0;
	fda = open("consume.txt", O_WRONLY|O_CREAT, 0664);
	write(fda, "wonderful Friday", 16);
	printf("written\n");
	close(fda);
	return 0;
}

