#%%
from pyspark.sql import SparkSession
spark = SparkSession.builder.appName("app").master("local[*]").getOrCreate()
jdbcdf = spark.read.format("jdbc")\
            .option("driver","org.postgresql.Driver")\
            .option("url","jdbc:postgresql://139.155.70.177:5432/trajectory")\
            .option("dbtable","lastappeared")\
            .option("user","postgres")\
            .option("password","zzjz123")\
            .load()
jdbcdf.show()