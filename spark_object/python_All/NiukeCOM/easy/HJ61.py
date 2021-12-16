# 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。

# 数据范围：，。

# 本题含有多组样例输入。

# 输入描述：
# 输入两个int整数

# 输出描述：
# 输出结果，int型
#%%
def func(num1,num2):
        if(num1==0 or num2 ==0 or num1 ==1):
            return 1
        elif (num1>num2):
            return func(num1,num2)
        else:
            return func(num1,num2-1)+func(num1-num2,num2)
while True:
    try:
        x= input().split(" ")
        a= int(x[0])
        b= int(x[1])
        print(func(a,b))
    except:
        break
