# 绘制直方图hist，可做统计展示

#%%
import matplotlib.pyplot as plt
import random
y = [random.randint(25,75) for i in range(0,200)]
x = [i for i in range(0,200)]
plt.figure(figsize=(20,8),dpi=80)
#计算组数
d =20
#计算组距
num_bin = (max(y)-min(y))/d
#设置刻度
# plt.xticks(range(min(y),max(y)+d),y)
plt.grid()
plt.hist(y,20)
plt.show()


