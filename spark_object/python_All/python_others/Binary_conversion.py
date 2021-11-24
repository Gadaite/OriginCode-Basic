#%%
# 二进制转换测试

inputnum = int(input("输入待转换的数字："))
code = []
def trans2(num):
    if(num>=2):
        code.append(num%2)
        num = int(num/2)
        trans2(num)
    else:
       code.append(num)
trans2(inputnum)
res =""
for i in code:
    res = str(i)+res
result = int(res)
print("{0}的二进制转换结果为{1}".format(inputnum,result))

#%%
