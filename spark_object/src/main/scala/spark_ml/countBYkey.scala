package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object countBYkey extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd = sc.parallelize(Array((1, "cool"), (2, "good"), (1, "bad"), (1, "fine")))
        rdd.countByKey().foreach(println)
        /**
          * (2,1)
          * (1,3)
          */
    }
}