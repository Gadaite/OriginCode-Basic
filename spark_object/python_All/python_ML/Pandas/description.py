#%%
# head显示头几行
# tail显示后几行
# info显示信息
# describe显示基本统计
#%%
import pandas as pd
from pandas.io.pytables import TableIterator
from sqlalchemy import create_engine
from sqlalchemy.sql.expression import false
db_connection = create_engine("mysql+pymysql://root:zzjz123@139.155.70.177:3306/Gadaite")
datasource = pd.read_sql("select * from audi",db_connection)
datasource
#%%
# head显示前几行
datasource.head(7)
#%%
# tail显示后几行
datasource.tail(3)
#%%
# 显示df的概览
datasource.info()

# <class 'pandas.core.frame.DataFrame'>
# RangeIndex: 10668 entries, 0 to 10667
# Data columns (total 9 columns):
#  #   Column        Non-Null Count  Dtype  
# ---  ------        --------------  -----  
#  0   model         10668 non-null  object 
#  1   year          10668 non-null  int64  
#  2   price         10668 non-null  int64  
#  3   transmission  10668 non-null  object 
#  4   mileage       10668 non-null  int64  
#  5   fuelType      10668 non-null  object 
#  6   tax           10668 non-null  int64  
#  7   mpg           10668 non-null  float64
#  8   engineSize    10668 non-null  float64
# dtypes: float64(2), int64(4), object(3)
# memory usage: 750.2+ KB（此处为占用内存大小）
#%%
# 显示数字的基本统计量describe,只能统计数字类型
datasource.describe()

# count	10668.000000	10668.000000	10668.000000	10668.000000	10668.000000	10668.000000
# mean	2017.100675	22896.685039	24827.244001	126.011436	50.770022	1.930709
# std	2.167494	11714.841888	23505.257205	67.170294	12.949782	0.602957
# min	1997.000000	1490.000000	1.000000	0.000000	18.900000	0.000000
# 25%	2016.000000	15130.750000	5968.750000	125.000000	40.900000	1.500000
# 50%	2017.000000	20200.000000	19000.000000	145.000000	49.600000	2.000000
# 75%	2019.000000	27990.000000	36464.500000	145.000000	58.900000	2.000000
# max	2020.000000	145000.000000	323000.000000	580.000000	188.300000	6.300000

#%%排序的方式，按照某一列进行排序，默认升序排序
datasource.sort_values("price")
#%%降序排序
datasource.sort_values("price",False)
