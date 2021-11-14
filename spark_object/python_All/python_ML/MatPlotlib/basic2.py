# 简单绘图
# 刻度的显示以及旋转
# 图片的大小的设定
# 横纵坐标的标签
# 标题的设定
# 颜色的设定
# 线条的粗细
# 线条的样式
# 图例的设定
# 图例的位置
# 网格的添加
# 网格的透明度
# 网格的刻度，依据横纵坐标的刻度
#%%
import matplotlib.pyplot as plt
import random
x = [i for i in range(15)]
def func(x):
    if(x%2==0):
        x = x+2
    else:
        x = x-2
    return x
y = [func(i) for i in x]
ys = [2*func(i) for i in x]
plt.figure(figsize=(20,8),dpi=80)
def func1(x):
    return "random:{}".format(x)
plt.xticks(list(x),[func1(i) for i in list(x)])#x刻度
plt.yticks(range(0,50))#y刻度
plt.xlabel("自变量")
plt.ylabel("因变量")
plt.title("折线图绘制")
plt.grid(alpha = 1)#网格由刻度决定最小单元，alpha决定网格透明度
plt.plot(x,y,label="线1",color ="red",Linewidth =5)##Linewidth:线条粗细
plt.plot(x,ys,label = "线2",color ="blue",LineStyle = "-.")#LineStyle:线的样式，color：颜色
plt.legend(loc = "lower left")#添加图例的两步，上面的label，和这里的legend,图例的位置设置在loc参数中
plt.show()
# %%
