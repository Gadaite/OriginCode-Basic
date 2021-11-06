package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Distinct extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        var rdd = sc.parallelize(Array(("cool"), ("good"), ("bad"), ("fine"), ("good"), ("cool")))
        
        rdd.distinct().foreach(x =>print(x+" "))
        //cool bad good fine 

    }
}