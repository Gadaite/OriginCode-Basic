# 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
# 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
# 2、若只输入一字串，但匹配命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
# 3、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果仍不唯一，匹配失败。
# 例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
# 例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
# 4、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果唯一，匹配成功。例如输入：bo a，确定是命令board add，匹配成功。
# 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：b addr，无法匹配到相应的命令，所以执行结果为：unknow command。
# 6、若匹配失败，打印“unknown command”

# 注意：有多组输入。
# 数据范围：数据组数：，字符串长度
# 进阶：时间复杂度：，空间复杂度：
# 输入描述：
# 多行字符串，每行字符串一条命令

# 输出描述：
# 执行结果，每条命令输出一行

#%%
while True:
    keys = ["reset","reset board","board add","board delete","reboot backplane","backplane abort"]
    values = ["reset what","board fault","where to add","no board at all","impossible","install first"]
    try:
        x= input().split(" ")
        if(len(x)<1 or len(x)>2):
            print("unknown command")
        elif len(x)==1:
            for i in range(0,len(keys)):
                if keys[i][0:len(x)]==x[0]:
                    print(values[i])
                    break
                else:
                    print("unknown command")
        else:
            for i in range(1,len(keys)):
                a = keys[i].split(" ")[0]
                b = keys[i].split(" ")[1]
                if a[0:len(x[0])]==x[0] and b[0:len(x[1])]==x[1]:
                    print(values[i])
                    break
                else:
                    print("unknown command")

    except:
        break