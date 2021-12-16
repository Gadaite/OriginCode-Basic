"""
计算转为2进制数中1的个数
"""
#%%M1
x= int(input())
res =bin(int(x))
count =0
for i in res:
    if(i=='1'):
        count += 1
print(count)
#%%M2
x= int(input())
lst=[]
def func(x):
    lst.append(x%2)
    temp= int(x/2)
#     print(temp)
    if(temp>=2):        
        func(temp)
    else:
        lst.append(1)
    return list(reversed(lst))
count = 0
for i in func(x):
    if i == 1:
        count =count +1
print(count)