import random
list = [random.randint(1,20) for i in range(1,10)]
list
#%%
from functools import reduce
#%%
list_max = reduce(lambda x,y:x if x>y else y,list)
list_max
#%%
list_temp = list.copy()
list_temp.sort()
list_temp
#%%
list
#%%
list_res = sorted(list)
list_res
#%%
list_temp

#%%
""""
    sort()会改变原来的顺序
    sorted()不会改变原来的顺序
"""