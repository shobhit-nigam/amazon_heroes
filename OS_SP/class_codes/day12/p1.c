#include<stdio.h>
#include<unistd.h>

void main()
{
	int x = 100;	//some random value
	printf("valar morghulis\n");
	// some code
	x = fork();
	/////////////////////////////
	if (x==0)
	{
		printf("from child, valar dohaeris\n");
	}
	else
	{
		printf("eneccccgbihjvkbdulklbuubdhtbhgrjgdjllecrkejf\n");
	}
	////////////////////////////
	printf("both will execute this code\n");
	sleep(3);
	return;
}
