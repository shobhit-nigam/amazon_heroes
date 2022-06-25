#include<stdio.h>
#include<string.h>
#include<unistd.h>
#include<fcntl.h>

void prompt(){
	printf("shobhit@atlas$");
	return;
}

void myhead(){
	printf("implementation of myHead\n");
}

void myCat(){
	static char data[1000];
	int len=0, fd=0;
	static char buf[20];
	scanf("%s", buf);
	fd = open(buf, O_RDONLY);
	len = lseek(fd, 0, SEEK_END);
	lseek(fd, 0, SEEK_SET);
	read(fd, data, len);
	printf("%s", data);
	return;
}

void main(){
	static char buf[20];
	prompt();
	scanf("%s", buf);
	
	if (!strcmp(buf, "mycat"))
	{
		myCat();
	}
	else if(!strcmp(buf, "myhead"))
	{
		myhead();
	}
	else
	{
		printf("wrong command");
	}


	prompt();
	printf("\n");
	return;
}

