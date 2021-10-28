#%%
from sqlalchemy import create_engine
db_connnection = create_engine("mysql+pymysql://root:zzjz123@139.155.70.177:3306/Gadaite")
#%%
import pandas as pd
datasource = pd.read_sql_query("select * from audi",db_connnection)
datasource
