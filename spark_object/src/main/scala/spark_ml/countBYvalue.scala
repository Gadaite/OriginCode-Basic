package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object countBYvalue extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd = sc.parallelize(Array((1, "fine"), (2, "good"), (1, "bad"), (1, "fine")))
        val rdds = sc.parallelize(Seq((1, "fine"), (2, "good"), (1, "bad"), (1, "fine")))
        rdd.countByValue().foreach(println)
        /**
          * ((2,good),1)
            ((1,fine),2)
            ((1,bad),1)
          */
        rdds.countByValue().foreach(println)
        /**
          * ((2,good),1)
            ((1,fine),2)
            ((1,bad),1)
          */
    }
}