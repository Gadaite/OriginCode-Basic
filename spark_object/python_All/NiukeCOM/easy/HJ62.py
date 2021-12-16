# HJ62 查找输入整数二进制中1的个数
#%%
x= int(input())
temp = str(bin(int(x)))
count =0
for i in temp:
    if i=="1":
        count =count +1
print(count)
