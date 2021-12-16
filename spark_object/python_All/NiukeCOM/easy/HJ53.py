# 杨辉三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。

# 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。

# 数据范围： 

# 本题有多组输入数据
# 输入描述：
# 输入一个int整数

# 输出描述：
# 输出返回的int值
#%%打印杨辉三角,与本题类似
num =int(input())
a=[]
for i in range(num):
    a.append([])
    for j in range(num):
        a[i].append(0)
for i in range(num):
    a[i][0]=1
    a[i][i]=1
for i in range(2,num):
    for j in range(1,i):
        a[i][j]=a[i-1][j]+a[i-1][j-1]
c=[]
for i in range(num):
    b=[]
    for j in range(i+1):
        b.append(a[i][j])
    c.append(b)
print(num)
for i in c:
    print(i)
#%%,该题满足2324规律
while True:
    try:
        x = int(input())
        if(x<=3):
            print("-1")
        else:
            temp = x-3
            if(temp%4==0 or temp%4==2):
                print("2")
            if(temp%4==1):
                print("3")
            if(temp%4==3):
                print("4")
    except:
        break