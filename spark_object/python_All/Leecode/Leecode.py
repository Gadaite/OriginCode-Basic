# #%%
# num =int(input())
# a=[]
# for i in range(num):
#     a.append([])
#     for j in range(num):
#         a[i].append(0)
# for i in range(num):
#     a[i][0]=1
#     a[i][i]=1
# for i in range(2,num):
#     for j in range(1,i):
#         a[i][j]=a[i-1][j]+a[i-1][j-1]
# c=[]
# for i in range(num):
#     b=[]
#     for j in range(i+1):
#         b.append(a[i][j])
#     c.append(b)
# print(num)
# c
# #%%
# allowed = input()
# words = input().split(" ")
# a=[]
# count = 0
# for j in words:
#     for k in j:
#         if k not in allowed:
#             count += 1
#             break
# print(len(words)-count)
# print(allowed)
# words
# #%%
# s1 = "abc"
# s2  = "bca"
# lst1 =[]
# lst2 =[]
# for i in s1:
#     lst1.append(i)
# lst11 =lst1.sort()
# for j in s2:
#     lst2.append(j)
# lst22 = lst2.sort()
# count =0
# for i in len(s1):
#     if(lst11[i]!=lst22[i]):
#         count +=1
# if(count==0):
#     print("true")
# else:
#     print("false")

#%%
# s1 = "abc"
# s2  = "bca"
# if(sorted(s1)==sorted(s2)):
#     s =True
# else:
#     s =False
# print(s)
#%%
# x= int(input())
# lst=[]
# def func(x):
#     lst.append(x%2)
#     temp= int(x/2)
#     print(temp)
#     if(temp>=2):        
#         func(temp)
#     else:
#         lst.append(1)
#     return list(reversed(lst))
# count = 0
# for i in func(x):
#     if i == 1:
#         count =count +1
# print(count)
# %%
# start = int(input())
# lst = input().split(" ")
# count =0
# temp = int(lst[start-1])
# for i in range(start-1,len(lst)):
#     if(int(lst[i])>temp):
#         temp =int(lst[i])
#         count =count+1
# print(count)

#%%
# ori = [0,0]
# def func(str):
#     s1 = str[0]
#     s2 = str[1:]
#     if(s1 == 'A'):
#         ori[0] = ori[0]-int(s2)
#     if(s1 == 'D'):
#         ori[0] = ori[0]+int(s2)
#     if(s1 == 'W'):
#         ori[1] = ori[1]+int(s2)
#     if(s1 == 'S'):
#         ori[1] = ori[1]-int(s2)
#     return ori
# rulers= input().split(";")
# for i in rulers:
#     try:
#         if 0<= int(i[1:])<=99:
#             func(i)
#     except:
#         continue
# print(str(ori[0])+","+str(ori[1]))

#%%
ipClass2num = {
    'A':0,
    'B':0,
    'C':0,
    'D':0,
    'E':0,
    'ERROR':0,
    'PRIVATE':0,
}
# 私有IP地址和A,B,C,D,E类地址是不冲突的，也就是说需要同时+1
def check_ip(ip:str):
    ip_bit = ip.split('.')
    if len(ip_bit) != 4 or '' in ip_bit:  #ip 的长度为4 且每一位不为空
        return False
    for i in ip_bit:
        if int(i)<0 or int(i) >255:   #检查Ip每一个10位的值范围为0~255
            return False
    return True
def check_mask(mask:str):
    if not check_ip(mask):
        return False
    if mask == '255.255.255.255' or mask == '0.0.0.0':
        return False
    mask_list = mask.split('.')
    if len(mask_list) != 4:
        return False
    mask_bit = []
    for i in mask_list:#小数点隔开的每一数字段
        i = bin(int(i))#每一数字段转换为每一段的二进制数字段
        i = i[2:] #从每一段的二进制数字段的第三个数开始，因为前面有两个ob
        mask_bit.append(i.zfill(8)) #.zfill:返回指定长度的字符串，原字符串右对齐，前面填充0
    whole_mask = ''.join(mask_bit)
#     print(whole_mask)
    whole0_find = whole_mask.find("0")#查0从哪里开始
    whole1_rfind = whole_mask.rfind("1")#查1在哪里结束                   
    if whole1_rfind+1 == whole0_find:#两者位置差1位为正确
        return True
    else:
        return False
def check_private_ip(ip:str):
    # 三类私网
    ip_list = ip.split('.')
    if ip_list[0] == '10': return True
    if ip_list[0] == '172' and 16<=int(ip_list[1])<=31: return True
    if ip_list[0] == '192' and ip_list[1] == '168': return True
    return False
while True:
    try:
        s = input()
        ip = s.split('~')[0]
        mask = s.split('~')[1]
        if check_ip(ip):
            first = int(ip.split('.')[0])
            if first==127 or first==0:
                # 若不这样写，当类似于【0.*.*.*】和【127.*.*.*】的IP地址的子网掩码错误时，会额外计数
                continue
            if check_mask(mask):
                if check_private_ip(ip):
                    ipClass2num['PRIVATE'] += 1
                if 0<first<127: 
                    ipClass2num['A'] += 1
                elif 127<first<=191:
                    ipClass2num['B'] += 1
                elif 192<=first<=223:
                    ipClass2num['C'] += 1
                elif 224<=first<=239:
                    ipClass2num['D'] += 1
                elif 240<=first<=255:
                    ipClass2num['E'] += 1
            else:
                ipClass2num['ERROR'] += 1
        else:
            ipClass2num['ERROR'] += 1
    except:
        break
for v in ipClass2num.values():
    print(v,end=(' '))
