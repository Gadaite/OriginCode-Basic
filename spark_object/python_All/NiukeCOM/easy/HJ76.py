# 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。

# 例如：

# 1^3=1

# 2^3=3+5

# 3^3=7+9+11

# 4^3=13+15+17+19

# 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
# 本题含有多组输入数据。
# 数据范围：数据组数：，
# 进阶：时间复杂度：，空间复杂度：

# 输入描述：
# 输入一个int整数

# 输出描述：
# 输出分解后的string
#%%
while True:
    try:
        m = int(input())
        x= m**3
        avgx = x/m#使用平均数，左右m个值    
        lst=[]
        res=""
        if m%2==1:
            for i in range(0,m):
                lst.append(int(avgx-m+1+2.0*i))
        else:
            for i in range(0,m):
                lst.append(int(avgx+1-m+2.0*i))
        for i in range(0,len(lst)):
            res=res + str(lst[i])+"+"
        print(res[0:-1])
    except:
        break
#%%