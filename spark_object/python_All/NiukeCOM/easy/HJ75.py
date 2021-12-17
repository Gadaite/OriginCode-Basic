# 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。

# 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
# 数据范围：字符串长度：
# 进阶：时间复杂度：，空间复杂度：
# 输入描述：
# 输入两个只包含小写字母的字符串

# 输出描述：
# 输出一个整数，代表最大公共子串的长度

#%%
str1,str2 = input(),input()
if len(str1)>len(str2):
    str1,str2=str2,str1
Max = 0
for i in range(len(str1)):
    for j in range(i,len(str1)):
        if str1[i:j+1] in str2 and j+1-i > Max:
            Max = j+1-i
print(Max)
