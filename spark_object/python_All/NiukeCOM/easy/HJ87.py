# 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。

# 一、密码长度:

# 5 分: 小于等于4 个字符

# 10 分: 5 到7 字符

# 25 分: 大于等于8 个字符

# 二、字母:

# 0 分: 没有字母

# 10 分: 全都是小（大）写字母

# 20 分: 大小写混合字母

# 三、数字:

# 0 分: 没有数字

# 10 分: 1 个数字

# 20 分: 大于1 个数字

# 四、符号:

# 0 分: 没有符号

# 10 分: 1 个符号

# 25 分: 大于1 个符号

# 五、奖励:

# 2 分: 字母和数字

# 3 分: 字母、数字和符号

# 5 分: 大小写字母、数字和符号

# 最后的评分标准:

# >= 90: 非常安全

# >= 80: 安全（Secure）

# >= 70: 非常强

# >= 60: 强（Strong）

# >= 50: 一般（Average）

# >= 25: 弱（Weak）

# >= 0:  非常弱


# 对应输出为：

# VERY_SECURE

# SECURE

# VERY_STRONG

# STRONG

# AVERAGE

# WEAK

# VERY_WEAK


# 请根据输入的密码字符串，进行安全评定。

# 注：

# 字母：a-z, A-Z

# 数字：0-9

# 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)

# !"#$%&'()*+,-./     (ASCII码：0x21~0x2F)

# :;<=>?@             (ASCII码：0x3A~0x40)

# [\]^_`              (ASCII码：0x5B~0x60)

# {|}~                (ASCII码：0x7B~0x7E)

# 提示:
# 1 <= 字符串的长度<= 300
# 输入描述：
# 本题含有多组输入样例。
# 每组样例输入一个string的密码

# 输出描述：
# 每组样例输出密码等级

#%%
while True:
    try:
        x= input()
        def func1(x):#长度
            if(len(x)<=4):
                return int(5)
            elif 5<=len(x)<=7:
                return 10
            else:
                return 25
        def func2(x):#字母
            count1 =0
            count2 =0
            for i in x:
                if 'a'<=i<='z':
                    count1 += 1
                if 'A'<=i<='Z':
                    count2 += 1
            if(count1==0 and count2==0):
                return int(0)
            elif count1!=0 and count2!=0:
                return 20
            else:
                return 10
        def func3(x):#数字
            s="0123456789"
            count =0
            for i in x:
                if i in s:
                    count += 1
            if count==0:
                return int(0)
            elif count==1:
                return 10
            else:
                return 20
        def func4(x):#符号
            s = """!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~"""
            count =0
            for i in x:
                if i in s:
                    count += 1
            if count==0:
                return int(0)
            elif count==1:
                return 10
            else:
                return 25
        def func5():
            if func2(x)!=0 and func3(x)!=0 and func4(x)==0:
                return 2
            elif func2(x)==10 and func3(x)!=0 and func4(x)!=0:
                return 3
            elif func2(x)==20 and func3(x)!=0 and func4(x)!=0:
                return 5
            else:
                return int(0)
        res=0
        res = func1(x)+func2(x)+func3(x)+func4(x)+func5()
        if res>=90:
            print("VERY_SECURE")
        elif 80<=res<90:
            print("SECURE")
        elif 70<=res<80:
            print("VERY_STRONG")
        elif 60<=res<70:
            print("STRONG")
        elif 50<=res<60:
            print("AVERAGE")
        elif 25<=res<50:
            print("WEAK")
        else:
            print("VERY_WEAK")                 
    except:
        break
#%%
print(res)
#%%
func1(x)
#%%
func2(x)
#%%
func3(x)
#%%
func4(x)
#%%
func5()