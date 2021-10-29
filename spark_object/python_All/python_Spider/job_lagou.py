#%%
import requests
import csv
import json
import re
import time ##手动延缓时间防止超时
import pprint
#%%
#网站请求信息
# """
# Request URL: https://www.lagou.com/jobs/positionAjax.json?needAddtionalResult=false
# Request Method: POST
# Status Code: 200 
# """
#相应头信息
#请求头信息
# """
# :method: POST
# cookie: JSESSIONID=ABAAABAABEIABCIFB2036FDD8CD9EEFEC69D88C181A5285; WEBTJ-ID=20211030002938-17ccce2a5db200-0802ed1a751b73-57b1a33-921600-17ccce2a5dce6d; RECOMMEND_TIP=true; _ga=GA1.2.216669859.1635524980; _gid=GA1.2.205824733.1635524980; PRE_UTM=; PRE_LAND=https%3A%2F%2Fwww.lagou.com%2F; user_trace_token=20211030002941-b1a43ac5-3034-4706-872b-ea2feb4d6bb2; LGUID=20211030002941-f4107f73-5be2-4d4d-9a6d-086d581dd835; privacyPolicyPopup=false; LGSID=20211030002941-9332733d-73dc-4918-a5f7-3b9a503580f4; PRE_HOST=www.baidu.com; PRE_SITE=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DbWFMFYmoticl5mVKgK2WGiBzwfxOm2cUKG7OomGCdd%5F%26wd%3D%26eqid%3D81b84dd000000fee00000006617c216a; index_location_city=%E5%85%A8%E5%9B%BD; sajssdk_2015_cross_new_user=1; sensorsdata2015session=%7B%7D; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2217ccce2e21956d-0e3e323fdc1dd4-57b1a33-921600-17ccce2e21ab1d%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E8%87%AA%E7%84%B6%E6%90%9C%E7%B4%A2%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.baidu.com%2Flink%22%2C%22%24os%22%3A%22Windows%22%2C%22%24browser%22%3A%22Chrome%22%2C%22%24browser_version%22%3A%2295.0.4638.69%22%7D%2C%22%24device_id%22%3A%2217ccce2e21956d-0e3e323fdc1dd4-57b1a33-921600-17ccce2e21ab1d%22%7D; __lg_stoken__=3ba6665fce161d600b919733575e6e2adb9d723f3c6619fa6158485c8684d87832aaf7de897cf47c799d8174a5acdb1c9005bf7b36f7f653148903f5ca489a60546553881cdf; X_MIDDLE_TOKEN=6fe335fd60c9ae2123074fab045a07cb; TG-TRACK-CODE=index_search; X_HTTP_TOKEN=d28a57c73b77de6e35152553615c9f2c91d26bdca6; _gat=1; LGRID=20211030003236-4ae6e9b1-a941-45f8-a84d-c010c7f3d858; SEARCH_ID=72341b12c76646cf9ad0653c932e4795
# origin: https://www.lagou.com
# referer: https://www.lagou.com/jobs/list_%E5%A4%A7%E6%95%B0%E6%8D%AE?labelWords=&fromSearch=true&suginput=
# user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36
# """
#%%定义csv表结构与路径信息
f = open("/root/Github_files/spark_object/python_All/Dataset/LGjob_bigdata.csv",mode='a',encoding='utf-8',newline='')
csv_writer = csv.DictWriter(f,fieldnames=[
    "城市",
    "地区",
    "公司名称",
    "职位",
    "职位标签",
    "firstType",
    "secondType",
    "thirdType",
    "工作年限",
    "薪资",
    "工作性质",
    "所属行业",
    "学历要求",
    "公司优势",
    "福利标签",
    "公司人数",
    "详细位置",
    "任职要求",
    "详情网址"
])
csv_writer.writeheader()#写入表头
#%%请求与伪装
url = "https://www.lagou.com/jobs/positionAjax.json?needAddtionalResult=false"
headers ={
    #referer防盗链
    "referer": "https://www.lagou.com/jobs/list_%E5%A4%A7%E6%95%B0%E6%8D%AE?labelWords=&fromSearch=true&suginput=",
    #cookie用户信息
    "cookie": "JSESSIONID=ABAAABAABEIABCIFB2036FDD8CD9EEFEC69D88C181A5285; WEBTJ-ID=20211030002938-17ccce2a5db200-0802ed1a751b73-57b1a33-921600-17ccce2a5dce6d; RECOMMEND_TIP=true; _ga=GA1.2.216669859.1635524980; _gid=GA1.2.205824733.1635524980; PRE_UTM=; PRE_LAND=https%3A%2F%2Fwww.lagou.com%2F; user_trace_token=20211030002941-b1a43ac5-3034-4706-872b-ea2feb4d6bb2; LGUID=20211030002941-f4107f73-5be2-4d4d-9a6d-086d581dd835; privacyPolicyPopup=false; LGSID=20211030002941-9332733d-73dc-4918-a5f7-3b9a503580f4; PRE_HOST=www.baidu.com; PRE_SITE=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DbWFMFYmoticl5mVKgK2WGiBzwfxOm2cUKG7OomGCdd%5F%26wd%3D%26eqid%3D81b84dd000000fee00000006617c216a; index_location_city=%E5%85%A8%E5%9B%BD; sajssdk_2015_cross_new_user=1; sensorsdata2015session=%7B%7D; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2217ccce2e21956d-0e3e323fdc1dd4-57b1a33-921600-17ccce2e21ab1d%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E8%87%AA%E7%84%B6%E6%90%9C%E7%B4%A2%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.baidu.com%2Flink%22%2C%22%24os%22%3A%22Windows%22%2C%22%24browser%22%3A%22Chrome%22%2C%22%24browser_version%22%3A%2295.0.4638.69%22%7D%2C%22%24device_id%22%3A%2217ccce2e21956d-0e3e323fdc1dd4-57b1a33-921600-17ccce2e21ab1d%22%7D; __lg_stoken__=3ba6665fce161d600b919733575e6e2adb9d723f3c6619fa6158485c8684d87832aaf7de897cf47c799d8174a5acdb1c9005bf7b36f7f653148903f5ca489a60546553881cdf; X_MIDDLE_TOKEN=6fe335fd60c9ae2123074fab045a07cb; TG-TRACK-CODE=index_search; X_HTTP_TOKEN=d28a57c73b77de6e35152553615c9f2c91d26bdca6; _gat=1; LGRID=20211030003236-4ae6e9b1-a941-45f8-a84d-c010c7f3d858; SEARCH_ID=72341b12c76646cf9ad0653c932e4795",
    #UA标识
    "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36"
}
data ={
    "first": "true",
    "pn": "1",
    "kd": "大数据",
    "labelWords": None,
    "fromSearch": "true",
    "suginput": None
}
response = requests.post(url=url,headers=headers,data=data)
##response            ##<Response [200]>
#%%获取数据
#response.text获取字符串的文本数据类型
#response.json()获取字典json数据
#pprint.pprint(response.json())格式化输出打印，具有层次感，便于查看
print(type(response.json())) ##<class 'dict'>
#%%解析数据
result = response.json()['content']['positionResult']['result']
# print(result)
for info in result:
    time.sleep(2.0)
    moreinfo_ID = info['positionId']
    moreinfo = f"https://www.lagou.com/jobs/{moreinfo_ID}.html"
    dict_info ={
        "城市":info['city'],
        "地区":info['district'],
        "公司名称":info['companyFullName'],
        "职位":info['positionName'],
        "职位标签":info['positionLables'],
        "firstType":info['firstType'],
        "secondType":info['secondType'],
        "thirdType":info['thirdType'],
        "工作年限":info['workYear'],
        "薪资":info['salary'],
        "工作性质":info['jobNature'],
        "所属行业":info['industryField'],
        "学历要求":info['education'],
        "公司优势":info['positionAdvantage'],
        "福利标签":",".join(info['companyLabelList']),
        "公司人数":info['companySize'],
        "详细位置":info['positionAddress'],
        ##"任职要求":','.join(info['positionDetail'].split("\\n<br>")),
        "任职要求":info['positionDetail'].replace('\n<br>',""),
        "详情网址":moreinfo
    }
    print(dict_info)
#%%写入数据
csv_writer.writerow(dict_info)
#%%

