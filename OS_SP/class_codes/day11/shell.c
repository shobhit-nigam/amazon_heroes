#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include<stdlib.h>
#include<fcntl.h>
void prompt()
{
	printf("\n[amazon@localhost home]$");		//to print the prompt

}
int main()
{

 int a=0;
 while(a==0)                                     
 {		
	prompt();
	char delim[]=" ";				//setting whitespace as a delimitor
	char inputArray [50];
	fgets(inputArray,30,stdin);		
	char buf[500]=" ";
	int fd=0;
	char* command=strtok(inputArray,delim); 	//seperation of command from input string	
	char* operand=strtok(NULL,delim);		//seperation of argument from input string
	int i = 0;
	operand[strlen(operand)-1] = 0;
	for(i=0; i<10; i++)
		{
			printf("%d and %c\n", operand[i], operand[i]);
		}

	if(strncmp(command,"exit",4)==0)
	{

		break;
	}
	else if( (strcmp(command,"mycat")==0))
	{
	
		char flName[64]=" ";
		int i =0;
	//	sprintf(flName,"%s",operand);		//formatting the filename
		strcpy(flName, operand);

	        fd= open("food.txt",O_RDONLY);		//passing formatted file name ****returns -1 for fd****
        //	fd=fileno(file);
		read(fd,buf,700);			
		printf(buf);				
		close(fd);	
	}
	else if(strcmp(command,"myhead")==0)
	{
		int count,i=0;
		fd=open("a",O_RDONLY);
		read(fd,buf,700);
		for(i=0;i<sizeof(buf);i++)

		{
			if((buf[i]=="\n")&&(count>10))
			{
				count++;
				printf(buf[i]);
			}
			else
			{ 	
				break;

			}
		}	
		printf(buf);
		close(fd);
	}
	else
	{
		printf("invalid command");
	}
 }	
	
	return 0;
}
