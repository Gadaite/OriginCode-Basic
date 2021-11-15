# 索引也可以修改值
# 修改与索引类似，修改同时也支持按照条件进行修改
# 裁剪clip
# nan是float，需要先转换类型才能赋值
#%%
import numpy as np
import random
from numpy.core.fromnumeric import clip, shape

x= np.array([random.randint(10,20) for i in range(100)]).reshape(10,10)
print("行数:{}".format(shape(x)))
for i in range(0,10):
    for j in range(0,10):
        print(x[i][j],end=" ")
    print()
print("取某一行")
print(x<15)
print("-----"*10)
y = np.where(x<15,0,1)#类似与三元运算符
z = x.clip(10,18)#小于10的替换为10，大于18的替换为18
print(y)
print(z)
print("-----"*10)

y = y.astype(float)
y[2:3][:] = np.nan
print(y)
