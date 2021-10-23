
#%%
#%%
import pandas as pd
df = pd.read_csv("/root/Github_files/python_All/Dataset/线性不可分类别.csv")
print(len(df))
##1000行数据
#%%
result = []
datasets = []
all_number = len(df)
per_sub = int(input("每箱的个数"))

for i in range(0,(int(all_number/per_sub) if(all_number%per_sub==0 ) else int(all_number/per_sub)+1)):
    datasets.append(df[i*per_sub:min((i+1)*per_sub,all_number)][:])
    noo = input("输入当前流水号：")
    result.append([str(i+1),str(min((i+1)*per_sub,all_number)-i*per_sub),noo])
    print("第%d箱，箱内个数%d，流水号%s"%((i+1),(min((i+1)*per_sub,all_number)-i*per_sub),noo))
    print(result[i])
    print(datasets[i])
    datasets[i]
def savetocsv(m):
    datasets[m].to_csv("datasets_%d.csv"%(m))


#%%
print("hello world")
