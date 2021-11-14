# 绘制10点到11点的时间的温度
# 简单绘图
# 刻度的显示以及旋转
# 图片的大小的设定
# 横纵坐标的标签
# 标题的设定
#%%
import matplotlib.pyplot as plt
import random
x= range(0,120)
y = [random.randint(15,35) for i in range(120)]
#设置图片的大小
plt.figure(figsize=(20,8),dpi=80)
plt.plot(x,y)
def func(x):
    hour = 10 +int(x/60)
    m = int(x%60)
    return [hour,m]
#调整x的刻度
x1 = list(x)[::10]
x2 = ["{0}点{1}分".format(func(i)[0],func(i)[1]) for i in x1]
# print(len(x1),len(x2))##    12 12 
plt.xticks(x1,x2,rotation =45)##此处的旋转方向为逆时针
#添加描述信息
plt.ylabel("温度：摄氏度")
plt.xlabel("时间")
plt.title("时间温度表")
plt.show()

#%%
