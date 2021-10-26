#%%
dict = {"a":{"b":1,"c":2,"d":3}}
print(type(dict["a"]))
dict["a"]
#%%
print(type(dict["a"]["b"]))
dict["a"]["b"]
#%%
type(dict)
#%%
import json
r = [{'b':1,'c':2,'d':3}]
w = r[0]
ss = json.loads(w)
ss['b']