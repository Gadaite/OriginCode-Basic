# 两拨数据的拼接
# 竖直拼接vstack
# 水平拼接hstack
# 数组行列的交换
#%%
import numpy as np
import random

from numpy.core.defchararray import array

D1 = np.array([random.randint(1,10) for i in range(0,10)]).reshape(2,5)
D2 = np.array([random.randint(81,90) for i in range(0,10)]).reshape(2,5)
Dv = np.vstack((D1,D2))
print(Dv)
print("-----"*10)
Dh = np.hstack((D1,D2))
print(Dh)
print("-----"*10)
arr = np.array([i for i in range(0,10)]).reshape(2,5)
arr[[0,1],:] =arr[[1,0],:]
print(arr)

print("-----"*10)
arr[:,[0,1]] = arr[:,[1,0]]
print(arr)