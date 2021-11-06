package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Coalesce extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd = sc.parallelize(Array(1,2,3,4,5))
        println(rdd.getNumPartitions)
        
        //对数据进行重新分区
        val rdds = rdd.coalesce(3,true)
        println(rdds.getNumPartitions)
    }
}