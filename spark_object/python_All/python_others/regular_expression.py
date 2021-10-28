#%%
import re
"""
    re.match 尝试从字符串的起始位置匹配一个模式，
    如果不是起始位置匹配成功的话，match()就返回none。
    re.match(pattern, string, flags=0)
"""
#%%
print(re.match('www', 'www.runoob.com').span())  # 在起始位置匹配
#%%
print(re.match('com', 'www.runoob.com'))         # 不在起始位置匹配
#%%
str_one = "Cats are smarter than dogs"
#%%
"""
    # .* 表示任意匹配除换行符（\n、\r）之外的任何单个或多个字符
    # (.*?) 表示"非贪婪"模式，只保存第一个匹配到的子串
"""
#%%
matchObj = re.match( r'(.*) are (.*?) .*', str_one, re.M|re.I)
#%%
if matchObj:
   print ("matchObj.group() : ", matchObj.group())
   print ("matchObj.group(1) : ", matchObj.group(1))
   print ("matchObj.group(2) : ", matchObj.group(2))
else:
   print ("No match!!")

#%%
matchObj.group()
#%%
matchObj.group(0)
#%%
matchObj.group(1)