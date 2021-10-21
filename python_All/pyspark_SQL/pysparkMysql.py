#%%
from pyspark import SparkConf,SparkContext
from pyspark.sql import SparkSession
spark = SparkSession.builder.config(conf=SparkConf()).getOrCreate()
sc = spark.sparkContext
#%%
jdbcDF = spark.read.format("jdbc")\
    .option("user","root")\
    .option("driver","com.mysql.jdbc.Driver")\
    .option("password","zzjz123")\
    .option("dbtable","seeds_dataset")\
    .option("url","jdbc:mysql://139.155.70.177:3306/Gadaite")\
    .load()
#%%
jdbcDF.show()
#%%
jdbcDF.createOrReplaceTempView("seeds")
#%%
jdbcDF.printSchema()
#%%

