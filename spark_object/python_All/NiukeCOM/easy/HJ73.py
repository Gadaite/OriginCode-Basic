# 根据输入的日期，计算是这一年的第几天。
# 保证年份为4位数且日期合法。
# 进阶：时间复杂度：，空间复杂度：
# 输入描述：
# 输入一行，每行空格分割，分别是年，月，日

# 输出描述：
# 输出是这一年的第几天

#%%
x= input().split(" ")
year = int(x[0])
month = int(x[1])
day =int(x[2])
lst = [31,28,31,30,31,30,31,31,30,31,30,31]
if(year % 400 == 0 or (year % 100 != 0 and year % 4 == 0)):
    lst[1]=int(29)
res=0
if month==1:
    print(day)
else:
    for i in range(0,month-1):
        res =res+lst[i]
    res = res+day
    print(res)