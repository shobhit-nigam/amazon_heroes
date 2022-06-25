#include<stdio.h>
#include<unistd.h>
void main()
{
	int x = 30;
	printf("adrres of x = %u\n", &x);
	sleep(30);
	x = x+1;

	printf("adrres of x = %u\n", &x);
	sleep(50);
	return;
}
