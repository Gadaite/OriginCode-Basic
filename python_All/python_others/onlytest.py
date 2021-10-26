
#%%
import time
import random
start=time.time()
y=[random.randint(1,10000000000) for i in range(0,100)]
y
#%%
count =0 
for i in range(0,99):
    for j in range(i+1,100):
        if y[i] > y[j]:
            y[i], y[j]=y[j], y[i]
        count = count+1
        if(time.time()-start >= 20):
            break

print(y)
end=time.time()
print(end-start)
# %%
print("hello !!")