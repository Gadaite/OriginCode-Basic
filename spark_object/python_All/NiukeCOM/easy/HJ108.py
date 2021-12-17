# 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。

# 数据范围：
# 输入描述：
# 输入两个正整数A和B。

# 输出描述：
# 输出A和B的最小公倍数。

#%%
while True:
    try:
        x=input().split(" ")
        a= int(x[0])
        b= int(x[1])
        for i in range(1,min(a,b)+1):
            if (max(a,b)*i)%min(a,b)==0:
                print(max(a,b)*i)
                break
    except:
        break