#%%
from sklearn.base import RegressorMixin
# from sklearn.externals.six import X
from sklearn.linear_model import LinearRegression
from sklearn.datasets import load_boston
#%%
#加载只有两个特征的数据集
boston = load_boston()
feature = boston.data[:,0:2]
feature
#%%
target = boston.target
target
#%%创建线性回归对象
regression = LinearRegression()
#%%拟合线性回归模型
model = regression.fit(feature,target)
model
#%%模型预测部分
#查看截距
model.intercept_
#%%查看 特征权重
model.coef_
#%%查看目标向量的值
target[0]
#%%模型预测第一个样本的值
model.predict(feature)[0]
#%%
x = boston["data"]
x
#%%
y = boston["target"]
y
#%%
boston.keys()