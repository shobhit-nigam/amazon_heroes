#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>

// two way communication using fifos
//
int  main()
{
        int fda = 10, fdb =10;
	int i=100;
        char buf[100];
        fda=open("test",O_RDONLY);
	fdb=open("test2",O_WRONLY);
	printf("Press '1' to write or '2' to read\n");
	scanf("%d",&i);
	getchar();
	// scanf reads an integer, enter is read by fgets 
	switch(i)
	{
	case 1:
		printf("Please write your message\n");
		fgets(buf, 100 , stdin);
		printf("read data -->%d\n", buf[0]);
		write(fdb, buf, 100);
       
		break;

	case 2:
		read(fda,buf,100);
		printf("Reading message is %s\n",buf);
		break;

	default:
		printf("wrong choice \n");
		break;
	}	
	return 0;
}
