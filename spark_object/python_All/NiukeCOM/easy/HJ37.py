# 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
#%%
while True:  
    try:
        x= int(input())
        m1 = 1
        m2 = 0
        m3 = 0
        for i in range(1,x):
            m3 = m3 +m2
            m2 = m1
            m1 = m3
        print(m1+m2+m3)

    except:
        break
    