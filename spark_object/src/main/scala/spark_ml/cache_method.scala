package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
object cache_method extends App{
    override def main(args: Array[String]): Unit = {
        val conf  = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val array_test = sc.parallelize(Array(1,2,3,4,5))

        println(array_test)
        //ParallelCollectionRDD[0] at parallelize at cache_method.scala:9

        /**
         * cache 将数据内容计算并保存在计算节点的内存中，这个方法使用的是针对Spark的 Lazy 数据处理模式
         * 在 Lazy 模式中，数据在编译和未使用时是不进行计算的，仅仅保存其存储地址，只有在Action方法到来是才进行计算
         * 好处：减少存储空间，提高利用率
         */
        println(array_test.cache())
        //ParallelCollectionRDD[0] at parallelize at cache_method.scala:9

        //foreach专门用于打印未行动的操作的数据，对数据进行提前计算
        array_test.foreach(println)

    }
}