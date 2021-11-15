#%%
# 基本数据以及画图
import numpy as np
from numpy.core.fromnumeric import shape
x= np.arange(0,100,0.1)
shape(x)
y = np.sin(x)
import matplotlib.pyplot as plt
plt.figure(figsize=(20,8),dpi=80)
plt.plot(x,y,LineStyle ="-.",color ="red",label ="sin(x)")
# plt.figure(figsize=(20,8),dpi=80)
plt.legend(loc = "upper left")
plt.grid()
plt.show()