package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Re_partition extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd = sc.parallelize(Array(1,2,3,4,5,6,7))

        //查看分区数
        println(rdd.getNumPartitions)//2
        println(rdd.partitions.length)//2

        //重新分区
        val rdds = rdd.coalesce(2,true)
        val rddss = rdd.repartition(3)

        //再次查看分区数
        println(rdds.getNumPartitions)//2
        println(rdds.partitions.length)//2

        println(rddss.getNumPartitions)//3
        println(rddss.partitions.length)//3


    }
}