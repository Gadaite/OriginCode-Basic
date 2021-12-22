# 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
# 保证输入的整数最后一位不是 0 。

# 数据范围： 
# 输入描述：
# 输入一个int型整数

# 输出描述：
# 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

#%%
x= input()
y=""
for ch in x:
    y = ch +y
str =""
for i in y:
    if i not in str:
        str = str + i
print(str) 