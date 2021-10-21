#%%
import requests,json
from jsonpath import jsonpath
Hn,name,url0 = {'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.81 Safari/537.36 Edg/94.0.992.50',
      'cookie':'BIDUPSID=19802A8DB15EBD678EE38C551FAF13F8; PSTM=1626401156; BAIDUID=19802A8DB15EBD67CCA14D1C324C0CA8:FG=1; __yjs_duid=1_e36c642fea308e68e39706a7fd22eab01626514650481; BDUSS=JEdU9TLW1Lbzg3aDZDUlNQRWtCU0R3c2oxLU9JaEhWSHR6djVDd1FZNE9RWFpoRVFBQUFBJCQAAAAAAAAAAAEAAAA44kmjx--67LfjtMcwMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA60TmEOtE5hfm; BDUSS_BFESS=JEdU9TLW1Lbzg3aDZDUlNQRWtCU0R3c2oxLU9JaEhWSHR6djVDd1FZNE9RWFpoRVFBQUFBJCQAAAAAAAAAAAEAAAA44kmjx--67LfjtMcwMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA60TmEOtE5hfm; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BDSFRCVID_BFESS=IMKOJeC62CnXB7cHHxdEMGDsQIcHi1TTH6aovDoQqXHLrdt7heMXEG0PVx8g0KAbU2tUogKKWeOTHxCF_2uxOjjg8UtVJeC6EG0Ptf8g0f5; H_BDCLCKID_SF_BFESS=tJ-q_I8btK03fP36q4Rh-tFyMMntetJyaR3A2lvvWJ5TMCoJhl7IjPtnyh7b0xrx3T7IaROd2CjxShPC-tn-Q-4uKJ77Wnjbbnv30l693l02VMQ9e-t2yU_V3H5JL4RMW23U0l7mWPnTsxA45J7cM4IseboJLfT-0bc4KKJxbnLWeIJIjj6jK4JKjH_eJTOP; BA_HECTOR=8lag8h2l0105812ha51gmsvel0q; Hmery-Time=2280562066; ab_sr=1.0.1_YjhhNDdmZTUzOGQ0ZmNjMGVhMzhkOGFmYmNkM2FjNDU2OTRlYTgzN2Y5MGMwZmNkYTk4YTVkMDVhMTM0YzIyMGY4NmRkZWVkYWQ0YzNhY2M2MzA1YjIzOWMyMmFkMDZiZDIxYjc2MjE0YTk5MGI3NDRkZTAyMTJmODliNzNhYTRiMzIxNTNlZjAxYjM4MWY2YmUwNjcyOGRlYjk1OGQ4MQ==',
      'Referer':'https://author.baidu.com/'},[],[]
url = 'https://mbd.baidu.com/webpage?tab=main&num=10&uk=rQPc0Y8q__Gp1weSdQ120A&source=pc&ctime=16320228486484&type=newhome&action=dynamic&format=jsonp&otherext=h5_20211019143439&Tenger-Mhor=2280562066&callback=__jsonp41634631580825'
re = requests.get(url,headers=Hn).text
n = re.index('(')
re1 = json.loads(re[n+1:-1])
rename = jsonpath(re1,'$..title')
reurl = jsonpath(re1,'$..defaultUrlHttp')
re360 = jsonpath(re1,'$..360pUrlHttp')
rescu = jsonpath(re1,'$..scurlhttp')
print(re1)
print(rename)
print(f'reu===>{reurl}')
print(f're3===>{re360}')
print(f'res===>{rescu}')

# %%
