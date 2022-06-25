#include<stdio.h>
#include<unistd.h>
void funca();
int ga = 99;
int gb = 88;

void main(){
	int ma = 33;
	int mb = 40;
	int *ptr = "hello wooooooorld";
	printf("adress of ga = %u\n", &ga);
	printf("adress of gb = %u\n", &gb);
	printf("adress of ma = %u\n", &ma);
	printf("adress of mb = %u\n", &mb);
	funca();
	printf("adress where string is stored = %u\n",ptr);

}

void funca()
{
	int ta = 100, tb = 120;
	static int tc = 300;
	printf("adress of ta = %u\n", &ta);
	printf("adress of tb = %u\n", &tb);
	printf("adress of tc = %u\n", &tc);
}
