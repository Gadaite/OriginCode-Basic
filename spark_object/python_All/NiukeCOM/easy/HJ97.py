# 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
# 0即不是正整数，也不是负数，不计入计算

# 数据范围：  ，输入的整数都满足 
# 输入描述：
# 本题有多组输入用例。
# 首先输入一个正整数n，
# 然后输入n个整数。

# 输出描述：
# 输出负数的个数，和所有正整数的平均值。

#%%
while True:
    try:
        x= int(input())
        lst= input().split(" ")
        count1 =0
        count2 =0
        sum =0
        for i in lst:
            if i[0]=='-':
                count1 =count1+1
            elif i=='0':
                continue               
            else:
                count2= count2+1
                sum = sum+int(i)
        if count2!=0:
            res = float(sum/count2)
        else:
            res = 0.0
        print("%d %.1f"%(count1,res))
    except:
        break