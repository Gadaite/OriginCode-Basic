#%%
from typing import List
from pyspark.sql import SparkSession
from pyspark import SparkConf
from pyspark.sql.types import StringType
spark = SparkSession.builder.config(conf=SparkConf()).getOrCreate()
sc = spark.sparkContext
#%%
list =[[8],[9],[10],[11],[12]]
rdd = sc.parallelize(list)
inputdf = spark.createDataFrame(rdd,schema=["object_id"])
inputdf.show()

#%%
import pyspark.sql.functions as F
def func():
    return "2020-10-23"
udf_func = F.udf(func,StringType())
#%%
output = inputdf.withColumn("date",udf_func())
output.show()
#%%
