
#%%
all_number = int(input("总数"))
per_sub = int(input("每箱的个数"))
import pandas as pd
data = {"NO": range(1,all_number+1)}
df = pd.DataFrame(data)
#%%
result = []
for i in range(0,(int(all_number/per_sub) if(all_number%per_sub==0 ) else int(all_number/per_sub)+1)):
    result.append(df[i*per_sub:min((i+1)*per_sub,all_number)][:])
    print("第%d箱，箱内个数%d，起始序号%d"%((i+1),(min((i+1)*per_sub,all_number)-i*per_sub),i*per_sub))
    print(result[i])