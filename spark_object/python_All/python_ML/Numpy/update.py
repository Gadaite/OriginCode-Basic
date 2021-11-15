# 索引也可以修改值
# 修改与索引类似，修改同时也支持按照条件进行修改
#%%
import numpy as np
import random
from numpy.core.fromnumeric import shape

x= np.array([random.randint(10,20) for i in range(100)]).reshape(10,10)
print("行数:{}".format(shape(x)))
for i in range(0,10):
    for j in range(0,10):
        print(x[i][j],end=" ")
    print()
print("取某一行")
print(x<15)