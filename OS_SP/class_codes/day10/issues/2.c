#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>

int  main()
{
        int fda = 10, fdb =10;
        int i=100;
        char buf[100];
        fda=open("test",O_WRONLY);
        fdb=open("test2",O_RDONLY);
        printf("Press '1' to write or '2' to read\n");
        scanf("%d",&i);
        switch(i)
        {
                case 1:
                printf("Please write your message\n");
//fgets(buf2,sizeof(buf2),stdin);
scanf("%s",buf);
                write(fda,buf,100);
                break;

                case 2:
                read(fdb,buf,100);
                printf("Reading message is %s\n",buf);
        break;
	////
	}
        return 0;
}
