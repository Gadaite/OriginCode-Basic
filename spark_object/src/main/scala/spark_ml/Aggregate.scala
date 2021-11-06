package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Aggregate extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd = sc.parallelize(Array(1,2,3,4,5,6))
        val rdds = rdd.coalesce(3,true)
        rdds.foreachPartition(it =>{
            it.foreach(x=>print(x.toString()+" "))
            println()
        })
        /**
          * 3  5
          * 1  6
          * 2  4
          */
        val result = rdds.aggregate(3)(_+_,_*_)
        println(result)
        /**
          * 3+3+5 =11
          * 3+1+6 =10
          * 3+2+4 =9
          * 3*11*10*9 = 33*90 = 2970
          */

    }
}