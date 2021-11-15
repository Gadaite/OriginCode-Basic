# 读取文件为DataFrame
# 读取csv文件,同样支持很多的方法包括json，excel等等
# 读取数据库mysql
# 读取mangodb等等
# 创建dataframe 
# 没有时显示空值

#%%
import pandas as pd
indf = pd.read_csv("/root/Github_files/spark_object/python_All/Dataset/iris-data.csv")
indf
#%%
# indf_sql = pd.read_sql("sql语句","数据库连接")
#%%
from sqlalchemy import create_engine
db_connnection = create_engine("mysql+pymysql://root:zzjz123@139.155.70.177:3306/Gadaite")
datasource = pd.read_sql("select * from audi limit 10",db_connnection)
datasource

#%%
import numpy as np
df1 = pd.DataFrame(np.arange(0,12).reshape(3,4),index=["1","2","3"],columns=["A","B","C","D"])
df1

#%%
dict2 = {"name":["yangyi"],"age":["23"]}
df2 = pd.DataFrame(dict2)
df2

#%%
dict3 = [{"name":"yangyi","age":"23"},{"name":"liuzu","age":"24"}]
df3 = pd.DataFrame(dict3)
df3

#%%
# 缺失值处理
dict4 = [{"name":"yangyi","age":"23"},{"name":"liuzu"}]
df4 = pd.DataFrame(dict4)
df4