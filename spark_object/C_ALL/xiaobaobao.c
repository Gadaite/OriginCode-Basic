#include<stdio.h>
int main ()
{
	int h,w;
	printf("请输入身高(厘米)和体重（公斤）");
	scanf ("%d  %d",&h,&w);
	int s=h-110;
	if(w-s>5)
	
		printf("过胖\n");
	
	else if(w-s==0)
	{

	printf("标准\n");
	}
	else
	{

	printf("过瘦\n");
	}
	
}
