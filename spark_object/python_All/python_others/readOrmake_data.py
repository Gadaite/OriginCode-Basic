#%%
#使用内置的数据集
from sklearn import datasets
#%%
"""
    part_one:加载内置数据集
"""
#加载其中的数据(手写数字识别)
digits = datasets.load_digits()
type(digits)
#%%
#创建特征矩阵
featrues = digits.data
featrues
#%%
#创建目标向量
target = digits.target
target
#%%
#查看第一个样本数据
featrues[0]
#%%
"""
    load_boston
    包含 503 个波士顿房价的观察值。这是一个用于研究回归算法的优质数据集。
    load_iris
    包含 150 个鸢尾花尺寸的观察值。这是一个用于研究分类算法的优质数据集。
    load_digits
    包含 1797 个手写数字图片的观察值。这是一个用于研究图像分类算法的优质数据
    集。
"""

"""
    part_two:创建仿真数据集
    make_regression:创建仿真数据用于线性回归
    make_classification:创建仿真数据集用于分类
    make_blobs:创建仿真数据集用于聚类

    make_regression 返回一个浮点数的特征矩阵和一个浮点数的目标向量
    make_classification 和 make_blobs 返回的是一个浮点数的特征矩阵和一
    个代表分类的整数目标矩阵
"""
#%%
from sklearn.datasets import make_regression
#%%
features, target, coefficients = make_regression(n_samples = 100,\
                                                n_features = 3,\
                                                n_informative = 3,\
                                                n_targets = 1,\
                                                noise = 0.0,\
                                                coef = True,\
                                                random_state = 1)\
#%%
# 查看特征矩阵和目标向量
print('Feature Matrix\n', features[:3])
print('Target Vector\n', target[:3])
#%%
"""
    在 make_regression 和 make_classification 中，n_informative 确定了用于生成目标向
    量的特征的数量。如果 n_informative 的值比总的特征数（n_features）小，则生成的
    数据集将包含多余的特征，这些特征可以通过特征选择技术识别出来

    make_classification 包含了一个 weights 参数，可以利用它生成不均衡的仿真数
    据集。举个例子，如果我们设置 weights = [.25, .75]，那么生成的数据集中，25% 的
    观察值属于第一个分类，75% 的观察值属于第二个分类
"""

#%%
from sklearn.datasets import make_classification
features, target = make_classification(n_samples = 100,
                                        n_features = 3,
                                        n_informative = 3,
                                        n_redundant = 0,
                                        n_classes = 2,
                                        weights = [.25, .75],
                                        random_state = 1)
# 查看特征矩阵和目标向量
print('Feature Matrix\n', features[:3])
print('Target Vector\n', target[:3])

#%%
# 加载库
from sklearn.datasets import make_blobs
# 生成特征矩阵和目标向量
features, target = make_blobs(n_samples = 1797,
                            n_features = 2,
                            centers = 3,
                            cluster_std = 0.5,
                            shuffle = True,
                            random_state = 1)
# 查看特征矩阵和目标向量
print('Feature Matrix\n', features[:3])
print('Target Vector\n', target[:3])
"""
    对于 make_blobs 来说，centers 参数决定了要生成多少个聚类。使用 matplotlib 可视
    化库，能将 make_blobs 生成的聚类可视化地显示出来
"""
#%%

#查看散点图
import matplotlib.pyplot as plt
#以下执行报错：
#mothod1:
# plt.scatter(featrues[:,0],featrues[:,1],c=target)
#mothod2:
# import numpy as np
# plt.scatter(featrues[:,0],featrues[:,1],c=np.squeeze(features[:,1]))
# plt.show()
#%%
featrues[:,0].size
#%%
features[:,1].size
#%%
plt.scatter(featrues[:,0],featrues[:,1],c=target)

#%%
"""
    part_three:readfile by pandas
"""
import pandas as pd
url = 'https://tinyurl.com/simulated_data'
df1 = pd.read_csv(url)
df1.head(2)
#%%
df2 = pd.read_excel()
df3 = pd.read_json()
"""
    pandas 的 read_sql_query 能在数据库中执行一个 SQL 查询语句并加载结果
"""
#%%
import pandas as pd
from sqlalchemy import create_engine
db_connection = create_engine("mysql+pymysql://root:zzjz123@139.155.70.177:3306/Gadaite")
#%%
dataframe = pd.read_sql_query('SELECT * FROM audi', db_connection)
dataframe.head(5)
#%%
