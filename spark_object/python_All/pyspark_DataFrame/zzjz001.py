#%%
from pyspark import SparkConf
from pyspark.sql import SparkSession
#%%
spark = SparkSession.builder.config(conf=SparkConf()).getOrCreate()
sc = spark.sparkContext
#%%
rdd_text = sc.parallelize()
#%%
rdd_text.collect()
#%%
