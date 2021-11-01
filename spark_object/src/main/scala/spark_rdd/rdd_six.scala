package spark_rdd

import org.apache.spark.sql.SparkSession

object rdd_six extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("app").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        
    }
}