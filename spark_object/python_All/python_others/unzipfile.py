#%%
import zipfile
filename = "/root/python_All/Others/解压test.zip"
#%%
password = "mima"
with zipfile.ZipFile(filename) as zfile:
    zfile.extractall("/root/python_All/Others",pwd=password.encode("utf-8"))
"""
    RuntimeError: Bad password for file <ZipInfo 
    filename='╜Γ╤╣test.txt' compress_type=deflate external_attr=0x20 file_size=31 
    compress_size=46>
    ///解压失败
"""
#%%
#定义解压函数
def unzipfile(filename,password):
    #password = '1234'
    try:
        with zipfile.ZipFile(filename) as zfile:
            zfile.extractall("/root/python_All/Others",pwd=password.encode("utf-8"))
        return True
    except:
        return False
#定义候选字符集
chars = "abcdefghijklmnopqrstuvwxyz\
    123456789\
        ABCDEFGHIJKLMNOPQRSTUVWXYZ!\
            ~!@#$%^&*()_+"
import itertools
for i in range(1,20):
    for c in itertools.permutations(chars,i):
        password = "".join(c)
        result = unzipfile(filename,password)
        if not result:
            print("unzip fail:",password)
        else:
            print("unzip success",password)
            break