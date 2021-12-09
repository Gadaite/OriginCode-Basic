#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2019/8/31 17:44
# @Author  : SeniorZhu1994
# @Email   : SeniorZhu1994@
# @Site    : 
# @File    : 计算字符串的相似度.py
# @Software: PyCharm
# @Describe: 

# 链接：https: // www.nowcoder.com / questionTerminal / f549ee08ddd84b8485a4fa9aefaf4a38
# 来源：牛客网


def editDistance(str1, str2):
    '''
    计算字符串的距离
    :param str1:
    :param str2:
    :return:
    '''
    len1, len2 = len(str1) + 1, len(str2) + 1
    dp = [[0 for i in range(len2)] for j in range(len1)]
    for i in range(len1):
        dp[i][0] = i
    for j in range(len2):
        dp[0][j] = j
    for i in range(1, len1):
        for j in range(1, len2):
            dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + (str1[i - 1] != str2[j - 1]))
    return dp[-1][-1]


while True:
    try:
        print("1/" + str(editDistance(input(), input()) + 1))
    except:
        break