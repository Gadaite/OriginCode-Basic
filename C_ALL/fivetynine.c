# include <stdio.h>
int add(int num1,int num2)
{
    int count = 0;
    for(int i =num1;i<=num2;i++)
    {
        count = count+i;
    }
    return count;
}
int main()
{
    int a=1;
    int b=3;
    int result = 0;
    result = add(a,b);   
    printf("%d",result);
    return 0;
}