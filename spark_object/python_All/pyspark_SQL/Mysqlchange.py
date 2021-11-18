#%%
from pyspark.sql import SparkSession
from pyspark import SparkConf,SparkContext, conf

spark = SparkSession.builder.appName("app").master("local[*]").getOrCreate()
sc = spark.sparkContext
#%%
jdbcDF = spark.read.format("jdbc")\
    .option("user","root")\
    .option("driver","com.mysql.jdbc.Driver")\
    .option("password","zzjz123")\
    .option("dbtable","Orders")\
    .option("url","jdbc:mysql://139.155.70.177:3306/Gadaite")\
    .load()
#%%查询
jdbcDF.show()
#%%增加或者更新数据

