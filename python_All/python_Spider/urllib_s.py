#%%
import urllib.request
response = urllib.request.urlopen("http://www.zhihu.com")
html = response.read()
print(html)
#%%
#导包
import requests
#%%
#请求
request_1 = requests.get("http://www.baidu.com")
request_1.content
#%%
#响应
