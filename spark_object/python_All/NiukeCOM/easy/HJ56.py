# 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。

# 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。

# 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。

# 输入n，请输出n以内(含n)完全数的个数。

# 数据范围： 


# 本题输入含有多组样例。

# 输入描述：
# 输入一个数字n

# 输出描述：
# 输出不超过n的完全数的个数

#%%
while True:
    try:
        x= int(input())
        count =0
        for i in range(1,x+1):
            sum =0           
            for j in range(1,int(i/2)+1):#(1,i)可能会带来运行超时的问题
                if(i%j==0):
                    sum = sum+j
            if(sum == i):
                count = count+1     
        print(count)                   
    except:
        break