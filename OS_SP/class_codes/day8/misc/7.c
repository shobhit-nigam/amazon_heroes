#include<stdio.h>

void func()
{
	char buf[6];
	scanf("%s", buf);
	printf("read data is --> %s\n", buf);
	return;
}

void main()
{
	func();
	return;
}
