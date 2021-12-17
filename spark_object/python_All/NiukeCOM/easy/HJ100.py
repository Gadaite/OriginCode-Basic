# 等差数列 2，5，8，11，14。。。。
# （从 2 开始的 3 为公差的等差数列）
# 输出求等差数列前n项和

# 本题有多组输入

# 数据范围： 
# 输入描述：
# 输入一个正整数n。

# 输出描述：
# 输出一个相加后的整数。

#%%
while True:
    try:
        n = int(input())
        sum =0
        for i in range(1,n+1):
            sum = sum +(3*i-1)
        print(sum)
    except:
        break