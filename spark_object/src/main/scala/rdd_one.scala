import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level, Logger}
object rdd_one extends App {
    
    val spark = SparkSession.builder.appName("app").master("local[*]").getOrCreate()
    val sc = spark.sparkContext
    // sc.setLogLevel("ERROR")
    spark.sparkContext.setLogLevel("WARN")
    val arr = Array(1,2,3,4,5)
    val rdd = sc.parallelize(arr)
    val sum = rdd.reduce(_ + _)
    println(sum)
    spark.stop()
}
