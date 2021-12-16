# 对字符串中的所有单词进行倒排。
# 说明：
# 1、构成单词的字符只有26个大写或小写英文字母；
# 2、非构成单词的字符均视为单词间隔符；
# 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
# 4、每个单词最长20个字母；
# 数据范围：字符串长度满足 
# 输入描述：
# 输入一行以空格来分隔的句子
# 输出描述：
# 输出句子的逆序
#%%
x= input()
res1 = ''
for i in x:
    temp =""
    for j in i:
        if(j.isalpha()):
            temp = temp+j
        else:
            temp=temp+" "
    res1 = res1+temp
lst = res1.split(" ")
for i in range(0,len(lst)):
    print(lst[len(lst)-1-i],end=" ")