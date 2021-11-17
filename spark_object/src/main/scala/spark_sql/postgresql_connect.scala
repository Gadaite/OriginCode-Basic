package spark_sql

import org.apache.spark.sql.SparkSession

object postgresql_connect extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder().appName("app").master("local[*]").getOrCreate()
        val jdbcdf = spark.read.format("jdbc")
            .option("driver","org.postgresql.Driver")
            .option("url","jdbc:postgresql://139.155.70.177:5432/trajectory")
            .option("dbtable","lastappeared")
            .option("user","postgres")
            .option("password","zzjz123")
            .load()
        jdbcdf.show()
    }
}