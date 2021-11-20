#%%
# pandas的切片
# 使用iloc以及loc 
# 直接把nan赋值给指定的位置
# 布尔索引
#%%
import pandas as pd
from pandas.io.pytables import TableIterator
from sqlalchemy import create_engine
from sqlalchemy.sql.expression import false
db_connection = create_engine("mysql+pymysql://root:zzjz123@139.155.70.177:3306/Gadaite")
datasource = pd.read_sql("select * from audi",db_connection)
datasource
#%%取前5数据,结构依然为dataframe
print(type(datasource[:5]))
datasource[:5]
#%%取某一列数据,结果为series
print(type(datasource["price"]))
datasource["price"]
#%%pandas还有更为标准的方式进行切片
import numpy as np
data = pd.DataFrame(np.arange(12).reshape(3,4),index=list("abc"),columns=list("ABCD"))
data
#%%使用loc对标签进行操作,结果为Name: B, dtype: int64
print(type(data.loc[:,"B"]))#<class 'pandas.core.series.Series'>
data.loc[:,"B"]
#%%
print(type(data.loc[:,["B","D"]]))#<class 'pandas.core.frame.DataFrame'>
data.loc[:,["B","D"]]
#%%使用iloc对位置进行操作
data
#%%
print(type(data.iloc[:,1]))#<class 'pandas.core.series.Series'>
data.iloc[:,1]
#%%
# 改变值为nan ，在dataframe中会自动转换为float，可以直接使用np.nan
datas = data.copy()
datas
datas.iloc[2,[1,3]] = np.nan
datas
#%%
# 不支持写法num<x<num2 ,需要拆分成两个条件
data[data["B"]>2]
#%%不支持使用and，需要改为&
# data[(data["B"]>2)and(data["B"]<7)]
# ValueError: The truth value of a Series is ambiguous. 
# Use a.empty, a.bool(), a.item(), a.any() or a.all().
#%%
data[(data["B"]>2) & (data["B"]<7)]
#%%
# 字符串的长度作为bool索引
datasource[datasource["transmission"].str.len()>6]
#%%
