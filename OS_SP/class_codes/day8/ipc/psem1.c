#include<stdio.h>
#include<semaphore.h>
#include<fcntl.h>
#include<unistd.h>

void main()
{
	sem_t *sem;
	sem = sem_open("/root", O_CREAT|O_RDWR, 0666, 1);
	printf("%d asking for semaphore\n", getpid());
	sem_wait(sem);
	printf("got the semaphore, will be busy for 10 seconds\n");
	sleep(10);
	// // // // // // /// /// 
	// critical section
	//  // / // //// ////////
	printf("done with my task, will release the semaphore\n");
	sleep(1);
	sem_post(sem);
	sem_close(sem);
	return;
}
