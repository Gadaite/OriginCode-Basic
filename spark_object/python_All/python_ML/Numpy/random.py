# 随机整数randint (起，始，形状)
# 均匀数组random.uniform (起，始，形状)
# 正态分布normal (中心，标准差，形状)
# 随机种植seed 
# 避免不相互影响使用copy() 
#%%
import numpy as np
import random

print("_________________随机种子测试____________________")
np.random.seed(10)

x = np.random.randint(10,20,(3,3))
print(x)
# array([[13, 17, 13],
#        [13, 13, 12],
#        [17, 13, 17]])

y = np.random.uniform(10,20,(3,3))
print(y)
# array([[18.57167509, 17.5880024 , 16.37020419],
#        [11.86989535, 11.70726784, 15.1602972 ],
#        [14.2245592 , 12.51451467, 15.55746685]])

z = np.random.normal(10,2,(3,3))
print(z)
print("_________________随机种子测试____________________")

arr = np.random.randint(0,20,(2,2))
print(arr)
