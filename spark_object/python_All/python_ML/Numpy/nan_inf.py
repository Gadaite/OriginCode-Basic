# nan是空，inf表示无穷，是float类型
# np.nan != np.nan
# 计算一列数据的均值或者中值
# 最大值：max 
# 最小值：min 
# 均值：mean 
# 中值：median 
# 极值：ptp 
# 标准差：std

#%%
import numpy as np
from numpy.core.fromnumeric import shape
res1 = (np.nan == np.nan)
print(res1) #False
res2 = (np.nan != np.nan)
print(res2) #True

print("-----"*20)
lin = [[0,2,np.nan,4,5],[11,np.nan,0,13,np.nan]]
datain = np.array(lin)
print(datain)

print(np.count_nonzero(datain)) #8
print(np.count_nonzero(datain != datain)) #3,即使nan值的个数
print(np.count_nonzero(np.isnan(datain))) #3,也是nan值得个数
print(np.sum(datain)) #nan,由于nan和任何值得求和都是nan，sum也支持按照维度进行计算，需要赋值求和，但数据应该支持空

# 常常替换nan的值为均值或者中值等等，或者删除有缺失值的这一行数据

# 均值
print(np.mean(datain,axis=0)) #[5.5 nan nan 8.5 nan]
print(np.mean(datain,axis=1)) #[nan nan]

# 中值
print(np.median(datain,axis=0)) #[5.5 nan nan 8.5 nan]

print("-----"*20)
t1 = np.arange(12).reshape(3,4).astype("float")
t1[1,2:] = np.nan
print(t1)

for i in range(shape(t1)[0]):
    # 当前所在行
    temp_row = t1[i,:]
    # 计算当前行nan个数
    nan_count = np.count_nonzero(temp_row != temp_row)
    if(nan_count != 0):
        # 当前行有nan，用当前行的均值替换
        # 当前不为nan的array
        temp_row_not_nan = temp_row[temp_row == temp_row]
        temp_row[temp_row != temp_row] = temp_row_not_nan.mean()
print(t1)



