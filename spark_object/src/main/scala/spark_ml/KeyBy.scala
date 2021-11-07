package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object KeyBy extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)

        /**
          * 为数据集中每个个体数据增加一个key，从而可与原来的个体数据形成键值对
          */
        var rdd = sc.parallelize(Array("one", "two", "three", "four", "five")) //创建数据集
        val rdds = rdd.keyBy(x => x.size)
        rdds.foreach(x=>println(x))
        /**(5,three)
            (4,four)
            (4,five)
            (3,one)
            (3,two)
          * 
          */
    }
}