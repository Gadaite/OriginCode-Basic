# 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。


# 提示:
# 0 <= index <= 11111111
# 1 <= value <= 100000

# 输入描述：
# 先输入键值对的个数n（1 <= n <= 500）
# 然后输入成对的index和value值，以空格隔开

# 输出描述：
# 输出合并后的键值对（多行）

#%%
num = int(input())
dict ={}
for i in range(0,num):
    a,b = map(int,input().split(" "))
    if a not in dict.keys():
        dict[a]=b
    else:
        dict[a]=dict[a]+b
for i in sorted(dict.keys()):
    print(i,dict[i])
