#include <stdio.h>
#include <string.h>
#include<stdlib.h>

void suma(int,int, int *);
void leer(int *);
void imprimeNum(int *);
void main()
{
	int a = -65535;
	int b = 1;
	int c;
	
	suma(a,b,&c);
	printf("%d",c);
	int res = 100;
	leer(&res);
	printf("%d",res);
	imprimeNum(&res);
}

//metodo suma 
void suma(int val1, int val2, int *res)
{
   *res = val1 + val2;
   if(*res>65535 || *res<0)
   { 
	*res = 0;
   }
 
	
}

void resta(int val1, int val2, int* res)
{
	*res = val1 - val2;
	if(*res>65535 || *res<0)
	{
	 *res =  0;
}
}

void divi(int val1, int val2, int* res)
{
	*res = val1 / val2;
	if(*res>65535 || *res<0)
	{
	*res = 0;
	}
}

void mul(int val1, int val2, int* res)
{
	*res = val1 * val2;
	if(*res>65535 || *res<0)
	{
	*res = 0;
	} 
}

void leer(int* id)
{
	int i=scanf("%u", id);
	scanf("%c");

  	

	while(i==0)
	{
	printf("solo leo numeros");
	i=scanf("%u", id);
	scanf("%c");
	}
		
}

void imprimeNum(int* num)
{
	printf("   %d   ",*num);
}

void printS(char *t) {
   if (*t == '\0')
      return;
   printf("%c", *t);
   print(++t);

}

