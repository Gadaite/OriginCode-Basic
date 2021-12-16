# 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
x=input()
str =""
for i in x:
    str = i+str
print(str)