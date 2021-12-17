# 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。

# 注：沿棋盘格之间的边缘线行走

# 本题含有多组样例输入。

# 数据范围： 


# 输入描述：
# 每组样例输入两个正整数n和m，用空格隔开。(1≤n,m≤8)

# 输出描述：
# 每组样例输出一行结果

#%%
while True:
    try:
        x= input().split(" ")
        n = int(x[0])
        m = int(x[1])
        # 每一种的总次数固定,C(m+n,m)==C(m+n,n),以C(m+n,n)为例
        sum = 1
        temp1=1
        temp2 =1
        for i in range(0,n):
            temp1 = temp1*(m+n-i)
            temp2 = temp2*(i+1)
        print(int(temp1/temp2))
    except:
        break
