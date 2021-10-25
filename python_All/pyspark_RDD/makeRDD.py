#%%
from pyspark import SparkConf,SparkContext
conf = SparkConf().setMaster("local").setAppName("app")
sc = SparkContext(conf=conf)
#%%
#同时从两个文件中读取数据为RDD
rdd = sc.textFile("/root/Github_files/python_All/Dataset/T*.txt")
rdd.collect()
#%%
#将两个文件作为rdd的数据
rdds = sc.wholeTextFiles("/root/Github_files/python_All/Dataset/T*.txt")
rdds.collect()
#%%
#python没有foreach
# 需要Python3，手动定义foreach方法
def foreach(function, iterator):
    for item in iterator:
        function(item)
#%%
foreach(print,rdd.collect())
#%%
#rdd分区
rdd_parttion = sc.textFile("/root/Github_files/python_All/Dataset/T1.txt",2)
rdd_parttion.collect() 
#%%
#保存分区数据并通过文件个数查看分区数(默认为核数)
rdd_parttion.saveAsTextFile("/root/Github_files/python_All/Dataset/RDD_parttion")
#%%
#更新设置默认分区数
conf.set("spark.default.parallelism",4)
#%%
#保存文件，查看默认分区是否修改
rdd.saveAsTextFile("/root/Github_files/python_All/Dataset/RDD_parttion")
#%%
#查看发现无法更改默认分区，set无效但不报错
sc.defaultParallelism
#%%
#分区数据的存储情况
rdd_1 = sc.parallelize([1,2,3,4],3)
rdd_1.collect()
#%%
rdd_1.saveAsTextFile("/root/Github_files/python_All/Dataset/RDD_parttion")
# 1/2/(3,4)
#%%
#数据如何分配到不同分区的：
"""
    @scala_spark:   
    def positions(length: Long, numSlices: Int): Iterator[(Int, Int)] = {
      (0 until numSlices).iterator.map { i =>
        val start = ((i * length) / numSlices).toInt
        val end = (((i + 1) * length) / numSlices).toInt
        (start, end)
      }
    }
"""
#%%
#文件数据分区,读取文件使用的是hadoop的方式
rdd_files = sc.textFile("/root/Github_files/python_All/Dataset/T*.txt",4)
rdd_files.saveAsTextFile("/root/Github_files/python_All/Dataset/RDD_parttion")
#%%
#spark以Hadoop按照行的方式读取数据，不是按照字节读取
#数据读取时以偏移量为单位的，偏移量不会被重新读取
rdd_2 = sc.parallelize([[1,2,3],[4,5,6],[7,8,9]])
rdd_3 = rdd_2.map(lambda x:x[2]**2)
rdd_3.collect()
#%%
#@used to test
list_1 = [1,2,3,4]
list_2 = [i**2 for i in list_1]
list_2
#%%
#转换rdd中的所有元素
rdd_4 = sc.parallelize([[1,2,3],[4,5,6],[7,8,9]])
rdd_5 = rdd_2.map(lambda x:[i**2 for i in x])
rdd_5.collect()
#%%
