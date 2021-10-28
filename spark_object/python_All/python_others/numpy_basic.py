#%%
import numpy as np

#创建一个行向量
list_row = np.array([1.0,2.0,3.0])
list_row
#%%
#创建一个列向量
list_column = np.array([[1.0],[2.0],[3.0]])
list_column
#%%
# 创建一个矩阵
matrix = np.array([[1, 2],[1, 2],[1, 2]])
matrix
#%%
from scipy import sparse
#加载稀疏矩阵
#%%
matrix_s = np.array([[0, 0],[0, 1],[3, 0]])
matrix_s
#%%
#创建一个压缩的稀疏行（Compressed Sparse Row，CSR）矩阵
matrix_sparse = sparse.csr_matrix(matrix_s)
print(matrix_sparse)
#%%
matrix_large = np.array([[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],\
    [0, 1, 0, 0, 0, 0, 0, 0, 0, 0],\
    [3, 0, 0, 0, 0, 0, 0, 0, 0, 0]])
matrix_large
#%%
matrix_large_sparse = sparse.csr_matrix(matrix_large)
print(matrix_large_sparse)
#%%
matrix_large_other = np.array([[5, 6, 0, 0, 0, 0, 0, 0, 0, 0],\
    [0, 1, 0, 0, 0, 0, 0, 0, 0, 0],\
    [3, 0, 0, 0, 0, 0, 0, 0, 0, 0]])
matrix_large_other_sparse = sparse.csr_matrix(matrix_large_other)
print(matrix_large_other_sparse)
#%%
#numpy直接索引取值，可以避免循环遍历
matrix1 = np.array([[1, 2, 3],[4, 5, 6],[7, 8, 9]])
matrix1[1,2]
#%%
matrix1[2:]
#%%
#shape、size 和 ndim 函数
#形状
print(matrix1.shape)
#元素个数：行*列
print(matrix1.size)
#矩阵维度
print(matrix1.ndim)
#%%
#对所有矩阵元素执行指定操作
#通过自定义函数，或者lambda表达式
#创建一个向量化函数并操作矩阵：
function_one = np.vectorize(lambda x:x**2)
function_one(matrix1)
#%%
#最值：max，min
np.max(matrix1)
#%%
np.max(matrix1[:1])
#%%
matrix1
#%%
matrix1.T
#%%
print(np.max(matrix1.T[1:]))
#%%
matrix2 = np.array([[51, 23, 3],[4, 15, 62],[47, 18, 39]])
matrix2
#%%
#列维度
np.max(matrix2,axis=0)
#%%
#行维度
np.min(matrix2,axis=1)
#%%
#平均值：mean、方差：var 和 标准差：std
#同样可以使用上面的维度，也可以操作整个ndarray
np.mean(matrix2)
#%%
np.var(matrix2)
#%%
np.std(matrix2,axis=0)
#%%
#矩阵的变形
matrix3 = np.array([[51, 23, 3],[4, 15, 62],[47, 18, 39],[23,25,24]])
matrix3.reshape(2,6)
#%%
matrix2.size
#%%
matrix2.reshape(1,-1)
#等价于flatten
#%%
matrix2.flatten()
#%%
#矩阵转置
matrix2[2:].T
#%%
matrix2
#%%
matrix2.T[2:]
#%%
#矩阵的秩
matrix4 = np.array([[1, 1, 1],[1, 1, 1],[1, 1, 1]])
np.linalg.matrix_rank(matrix4)
#计算行列式
np.linalg.det(matrix4)
#获取对角元素
print(matrix2)
matrix2.diagonal()
#%%
#对角线向上偏移
matrix2.diagonal(offset=1)
#对角线向下偏移
matrix2.diagonal(offset=-1)
#矩阵的迹：对角线元素的和：常被用在机器学习方法的底层计算
print(matrix2.trace())
    #同样可用对角线求和：
sum(matrix2.diagonal())

#计算特征值和特征向量
#%%
matrix5 = np.array([[1, -1, 3],[1, 1, 6],[3, 8, 9]])
eigenvalues,eigenvectors = np.linalg.eig(matrix5)
print(eigenvalues)
print(eigenvectors)

#%%
#矩阵点积
vector_a = np.array([1,2,3])
vector_b = np.array([4,5,6])
print(np.dot(vector_a,vector_b))
#等价于以下情况：使用@
vector_a@vector_b
#%%
#加减乘除为对应相加相减相乘相除
vector_a/vector_b
#%%
#矩阵的逆
print(matrix2)
np.linalg.inv(matrix2)

#%%
#伪随机数生成
#生成随机数种子
"""
多次返回相同的随机数对于获取可预测、可重复的结果是很有用的。
如果希望多次返回同样的随机数，
可以设置伪随机数生成器的“种子”（一个整数）。
如果在程序中用到了随机数，
则拥有相同“种子”的程序会生成同样的结果。
"""
np.random.seed(0)
#%%
#生成3个0.0到1.0之间的随机浮点数
np.random.random(3)
#%%
#生成3个0到10之间的随机整数
np.random.randint(0, 11, 3)
#%%
#从平均值是1.1且标准差是2.0的正态分布中抽取5个数
np.random.normal(1.1, 2.0, 5)
#%%
#从平均值是0.0且分散程度是1.0的logistics分布中抽取3个数
np.random.logistic(0.0, 1.0, 3)
#%%
#从大于或等于11.0并且小于12.0的范围中抽取4个数
np.random.uniform(11.0, 12.0, 4)
#%%




