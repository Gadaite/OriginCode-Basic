#%%
from pyspark.conf import SparkConf
from pyspark.ml.linalg import Vector,Vectors
from pyspark import SparkContext
from pyspark.sql import SparkSession
spark = SparkSession.builder.config(conf=SparkConf()).getOrCreate()

#%%
data = [(0, Vectors.dense([-1.0, -1.0 ]),""),
     (1, Vectors.dense([-1.0, 1.0 ]),""),
    (2, Vectors.dense([1.0, -1.0 ]),""),
     (3, Vectors.dense([1.0, 1.0]),"")]
df = spark.createDataFrame(data, ["id", "features","11"])
#%%
df.show()