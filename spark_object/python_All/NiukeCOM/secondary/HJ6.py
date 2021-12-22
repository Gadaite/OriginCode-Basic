# 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）


# 数据范围： 
# 输入描述：
# 输入一个整数

# 输出描述：
# 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。

#%%
import math

x= int(input())
for i in range(2,int(math.sqrt(x)+1)):
    while x%i==0:
        print(i,end=" ")
        x=x//i  
if x>2:
    print(x)      
    

#%%下面使用if是错误的结果，可以理解一下while和if的区别
import math
while True:
    try:
        x= int(input())
        for i in range(2,int(math.sqrt(x)+1)):
            if x%i==0:
                print(i,end=" ")
                x=x//i        
    except:
        break

