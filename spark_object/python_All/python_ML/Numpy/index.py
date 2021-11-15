# 索引
# 切片
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
print(x[2][:])
print("取不连续的行")
print(x[[2,4,6][:]])
# 取列与取行类似
# 取出值是numpy.int64类型
# 取不相邻的点的值
print(x[[0,1],[0,1]])