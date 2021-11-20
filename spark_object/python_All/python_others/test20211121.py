#%%
import pandas as pd
import numpy as np
data = pd.DataFrame(np.arange(20).reshape(5,4),index=list("01234"),columns=list("ABCD"))
data
#%%
data.iloc[0:2,:]