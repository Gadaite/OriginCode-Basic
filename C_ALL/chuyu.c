#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>

void* func(void *args){
	int i  =(int*)args;
	for(int j=0;j<=20;j++){
		printf("thread:%d,output:%d\n",i,j);
	}
	

}
int main(){
	for(int i=1;i<=3;i++){
		pthread_t tid;
		pthread_create(&tid,NULL,func,(void*)i);
	}
	sleep(1);
	

}
