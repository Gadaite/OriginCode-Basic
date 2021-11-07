package spark_ml

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object Reduce_method extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd = sc.parallelize(Array("one", "two", "three", "four", "five"))
        val rdds = rdd.reduce(_+_)//type :string
        println(rdds)
        //onetwothreefourfive
        val rddd = sc.makeRDD(Array(1,2,3,4,5,6))
        val rddds = rddd.reduce(_+_)
        println(rddds)
        //21
    }
}