#include<stdio.h>
#include<sys/ipc.h>

void main()
{
	key_t	k;
	k = ftok("/bin", 50);
	printf("%d\n",k);
	return;
}
