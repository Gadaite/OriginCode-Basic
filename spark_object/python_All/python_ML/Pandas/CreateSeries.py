# 索引创建Series ，可理解为带标签的一维数组
# 字典创建Series 
# series索引，字典方式，位置方式
# bool类型的索引
# 索引的属性
# ndarray的很多方法都适用与series 
# where方法，满足保留，不满足转为nan 


#%%
import pandas as pd
inlist = pd.Series([1,2,3],index=["A","B","C"])
print(inlist)
# A    1
# B    2
# C    3
# dtype: int64

dict = {"name":"yangyi","age":"23","code":"python"}
indict = pd.Series(dict)
print(indict)
# name    yangyi
# age         23
# code    python
# dtype: object 注意这里是object类型

#%%
# 字典推导式创建字典，并转化掉object类型
import string
dictA = {string.ascii_uppercase[i]:i for i in range(0,5)}
indictA = pd.Series(dictA).astype("float")
indictA
#%%
#索引和字典类似
indictA["A"]
#%%
#索引和数组类似
indictA[2]
#%%
# 多个索引,索引没有的时候返回nan
indictA[["A","B"]]
#%%
# bool类型的索引
indictA[indictA>3]

#%%
# 索引的属性
indictA.index
#%%
indictA.values

