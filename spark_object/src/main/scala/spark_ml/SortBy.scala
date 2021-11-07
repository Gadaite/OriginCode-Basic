package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SortBy extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd = sc.parallelize(Array((5, "b"), (6, "a"), (1, "f"), (3, "d"), (4, "c"), (2, "e")))

        val rdd_key1 = rdd.sortBy(x =>x._1,true)
        val rdd_key2 = rdd.sortBy(x =>x._1,false)

        val rdd_value1 = rdd.sortBy(x =>x._2,true)
        val rdd_value2 = rdd.sortBy(x =>x._2,false)

        //打印输出结果
        rdd_key1.foreach(println)
        rdd_key2.foreach(println)
        rdd_value1.foreach(println)
        rdd_value2.foreach(println)
    }
}