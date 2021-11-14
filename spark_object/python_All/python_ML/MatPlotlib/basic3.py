# 散点图的绘制scatter
# 散点图没有LineStyle属性设置
# 线的宽度可以在散点图中设置点的大小，且值应该是整数而非字符串
# 添加图例需要现在绘图中设置label，再使用legend,loc参数中可以设定图例的位置
#%%
import random
import matplotlib.pyplot as plt
x = [i for i in range(0,20)]
y = [random.randint(12,18) for i in range(0,20)]

plt.figure(figsize=(20,8),dpi=80)
plt.xticks(list(x),[i for i in list(x)])
plt.grid()
plt.xlabel("X")
plt.ylabel("Y")
plt.scatter(x,y,color ="red",label ="测试图",linewidths=10)
plt.title("散点测试图")
plt.legend(loc = "upper left")
plt.show()