# 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
# 本题含有多组样例输入。
# 数据范围：数据组数：，
# 进阶：时间复杂度：，空间复杂度：
# 输入描述：
# 输入一个int类型数字

# 输出描述：
# 输出转成二进制之后连续1的个数

#%%

while True:
    try:
        x= int(input())
        lst= str(bin(x))[2::].split("0")
        max=0
        for i in lst:
            if len(i)>max:
                max=len(i)
        print(max)
    except:
        break