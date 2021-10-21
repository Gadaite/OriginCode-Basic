#%%
import pandas as pd
#%%
#创建数据帧
dataframe = pd.DataFrame()
dataframe
#%%
dataframe['Name'] = ['Jacky Jackson', 'Steven Stevenson']
dataframe['Age'] = [38, 25]
dataframe['Driver'] = [True, False]
dataframe
#%%
#创建一行并添加
new_row = pd.Series(["xiaobao","22","False"],index=["Name","Age","Driver"])
dataframe.append(new_row,ignore_index=True)
dataframe.shape
#%%
#描述的基本统计量
dataframe.describe()
#%%
dataframe.describe().mean()

#%%
"""重新加载数据"""
#%%
from sqlalchemy import create_engine
db_connection = create_engine("mysql+pymysql://root:zzjz123@139.155.70.177:3306/Gadaite")
#%%
audi = pd.read_sql_query("select * from audi",db_connection)
audi.head(10)
#%%
type(audi)
#%%
#按照行index索引
audi.iloc[101:109]
#%%
#按照列column索引
#先设置索引行
auditemp = audi.set_index(audi["transmission"])
auditemp
#再通过索引值进行索引
auditemp.loc["Manual"]
#%%
#条件过滤
print(audi[(audi['year']==2019) & (audi['fuelType']=='Petrol')])
#%%
print(audi['year'].replace(2019,2049).head(2))
#%%
audi
#%%
print(audi['transmission'].replace("Manual","manual").head(2))
#replace同时也支持正则表达式
#%%
#重命名
print(audi.rename(columns={"model":"Car_name"}))
#%%
import collections
column_name = collections.defaultdict(str)
for name in audi.columns:
    column_name[name]
column_name
#%%
#其他描述性统计量
"""
    pandas 还提供了计算方差（var）、标准差（std）、
    峰态（kurt）、偏态（skew）、平均值标准误差（sem）、众数（mode）、中位数（median）
    以及很多其他描述性统计量的方法
"""
audi.count()
#%%
audi.kurt()
#%%
"""
    使用 unique 来查看由某一列中全部的唯一值组成的数组
    使用 value_counts，它会显示所有的唯一值以及它们出现的次数
    只是想统计有多少个唯一值，则可以使用 nunique
"""
audi["model"].unique()
#%%
audi["model"].value_counts()
#%%
audi["model"].nunique()
#%%
"""isnull 和 notnull 都能返回布尔型的值来表示一个值是否缺失"""
#%%

