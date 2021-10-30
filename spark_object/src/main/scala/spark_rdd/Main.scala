package spark_rdd

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
object Main extends App {
  val spark = SparkSession.builder.appName("Simple Application").master("local[*]").getOrCreate()
  val sc = spark.sparkContext
  val array_1 = Array((1,2,3),(4,5,6),(7,8,9))
  val rdd_1 = sc.parallelize(array_1)
  val df_1 = spark.createDataFrame(rdd_1)
  df_1.show()
  println("Hello, World!")
}