package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object GroupBy extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd = sc.parallelize(Array(1,2,3,4,5))
        val rdd_1 = rdd.groupBy(x =>x%2==0)
        rdd_1.foreach(x =>print(x.toString()+" "))
        //(false,CompactBuffer(1, 3, 5)) (true,CompactBuffer(2, 4))


        val result = rdd_1.collect()
        println(rdd_1.collect())
        //[Lscala.Tuple2;@721d5b74

    }
}