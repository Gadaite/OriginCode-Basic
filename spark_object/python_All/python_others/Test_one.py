#%%
from functools import reduce
str = "she  says    that    carrots    are    very good for people's   health."
res_str = reduce(lambda x,y :x.strip()+" "+y.strip(),str.split(" "))
print(res_str)
