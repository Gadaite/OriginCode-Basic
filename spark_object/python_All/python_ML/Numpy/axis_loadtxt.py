# axis维度的概念，按照块往下数


# numpy也可以读取数据，从csv里面读取数据，使用loadtxt

# fname:要读取的文件、文件名或生成器
# dtype:可选数据类型默认为float ,可以将科学计数法加载成其他格式
# delimiter:分割字符串默认是空格，可设置逗号等
# skiprows:跳过前多少行
# usecols:读取指定列
# unpack:True写入不同数据变量，FALSE写入一个数组变量,效果相当于按照对角线进行了旋转，就是转置的效果


# 转置还有其他的方法如下
# transpose
# T
# swapaxes

#%%
import numpy as np
import random
from numpy.core.fromnumeric import shape, swapaxes, transpose
x= np.array([random.randint(10,20) for i in range(100)]).reshape(10,10)
shape(x)

for i in range(0,10):
    for j in range(0,10):
        print(x[i][j],end=" ")
    print()

path = "/root/Github_files/spark_object/python_All/Dataset/线性不可分类别.csv"
csvdata = np.loadtxt(fname =path,dtype=float,skiprows=1,delimiter=",",unpack=True)
csvdata


