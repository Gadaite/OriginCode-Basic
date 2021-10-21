#%%
import pandas as pd
import numpy as np
datasource = pd.read_csv("/root/python_All/Dataset/randomdata.csv")
datasource
#%%
data = datasource.replace(590,np.NaN)