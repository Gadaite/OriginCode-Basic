#%%
lst1 = input().split(" ")
a1=int(lst1[0])
b1=int(lst1[1])
for i in range(1,max(a1,b1)+1):
    if(min(a1,b1)*i%max(a1,b1)==0):
        print(i*min(a1,b1))
        break 
#%%
count1 =0
count2 =0
sum =0
while True:
    try:
        x= int(input())
        if(x>=0):
            count1 =count1 +1
            sum =sum +x
        else:
            count2 = count2 +1
    except EOFError:
        print(count2)
        if(count1==0):
            print("0.0")
        else:
            print("%.1f"%(sum/count1))
            break
#%%
# 本题特殊的地方在于，要元素读取完之后，在except里break之前进行打印操作
# 正数个数
po_cnt = 0
# 正数和
po_sum = 0
# 负数个数
ne_cnt = 0
while True:
    try:
        num = int(input())
        if num > 0:
            po_cnt += 1
            po_sum += num
        elif num < 0:
            ne_cnt += 1
    except EOFError:
        print(ne_cnt)
        if po_cnt == 0:
            print('0.0')
        else:
            print(round(po_sum/po_cnt, 1))
        break

#%%
str = input()
res =""
for x in str:
    res = x + res
print(res)
#%%

n= int(input())
dic ={}

for i in range(0,n):
    temp = input().split(" ")
    a= int(temp[0])
    b= int(temp[1])
    if a not in dic:
        dic[a] =b
    else:
        dic[a] = int(dic[a]) + b


for i in sorted(dic.keys()):
    print(i,dic[i])



#%%
x= input()
str =""
temp =""
for i in x:
    temp = i + temp
for j in temp:
    if(j not in str):
        str =str + j
print(str)
#%%
x= input()
res =""
for i in x:
    if(i not in res):
        res =res + i
print(len(res))

#%%
x= input()
lst = x.split(" ")
res=" "
def func(ss):
    temp =""
    for i in ss:
        temp =i +temp
    temp =temp + " "
    return temp
for x in lst:
    res =res + func(x)
print(res)
#%%
lst=input().split(" ")
str =" "
for i in lst:
    str =i +" " + str
print(str)
#%%
x= int(input())
lst =[]
for i in range(x):
    lst.append(input())
res =sorted(lst)
for j in res:
    print(j)
#%%
x=input()
x2 =str(int(x,2))
count =0
for i in x2:
    if(i =='1'):
        count +=1
print(count)
#%%
