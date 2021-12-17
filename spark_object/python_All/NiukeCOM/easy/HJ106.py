# 将一个字符串str的内容颠倒过来，并输出。

# 数据范围：
# 输入描述：
# 输入一个字符串，可以有空格

# 输出描述：
# 输出逆序的字符串

#%%
while True:
    try:
        x= input()
        str =""
        for i in x:
            str = i+str
        print(str)
    except:
        break