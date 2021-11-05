#%%
from functools import reduce
#%%
list = [[1,2],[3],[4,5,6],[]]
#%%
ret = []
#%%
reduce(lambda x :ret.append(x),x for x in list)
ret
#%%
