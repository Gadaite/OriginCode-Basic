# 绘制条形图，常用于统计离散型数据
# 使用bar
# 直方图没有线宽的属性,但是有宽度属性
# 如果刻度信息太长，可以直接选择换行，也可以横着画图barh
# 横着画图需要使用height

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
plt.title("散点测试图_横")
plt.bar(x,y,color ="green",label ="测试图",width=0.5)
plt.yticks(list(y),[i for i in list(y)])
plt.figure(figsize=(20,8),dpi=80)
plt.barh(x,y,color ="green",label ="测试图",height=0.5)
plt.title("散点测试图_纵")
plt.legend(loc = "upper left")
plt.show()
