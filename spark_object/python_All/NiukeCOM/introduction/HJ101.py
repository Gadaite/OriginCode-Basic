# 输入整型数组和排序标识，对其元素按照升序或降序进行排序
# 输入个数
# 输入数据
# 选择升降序
#%%
count = int(input())
indata = input().split(" ")
lst=[]
for i in indata:
    lst.append(int(i))
r = input()
if r=='0':
    res = sorted(lst)
if r=='1':
    res = sorted(lst,reverse=True)
for i in res:
    print(i,end=" ")
