#include<stdio.h>
#include<unistd.h>

int main()
{
	printf("salaam\n");
	fork();
	printf("sat sri akaal\n");
	fork();
	printf("jai jinendra\n");
	sleep(1);
	return 0;
}
