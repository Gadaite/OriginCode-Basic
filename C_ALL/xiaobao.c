#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *func(void *arg)
{
	int *p_param = (int*)arg;
	int count =10;
	for(int h =0;h<count;h++){
		printf("子线程正在运行中！\n");
		*p_param = count;
		sleep(1);
	}
	printf("子线程退出！\n");
	//return((void*)0);
}

int main(int argc, char *argv[])
{
	//pthread_t tid;
	int ret;
	int param=0xff;
	pthread_t tid;
	ret=pthread_create(&tid,NULL,func,(void*)&param);
	if(ret!=0){
		printf("创建线程失败！\n");
	}
	else{
		printf("创建子线程成功！\n");
	}
	while(param){
                printf("主线程运行中，线程参数：%d\n",param);
		sleep(1);
        }
	printf("主线程退出！");
	return 0;
}

