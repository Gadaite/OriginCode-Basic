package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object  ZIP extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        /**
          * 将若干个RDD压缩成一个新的RDD,进而形成一系列的键值对存储形式的新RDD
          * 这里数据是压缩成一个双重的键值对形式的数据
          */
        val rdd1 = Array(1, 2, 3, 4, 5, 6) //创建数据集1
        val rdd2 = Array("a", "b", "c", "d", "e", "f") //创建数据集1
        val rdd3 = Array("g", "h", "i", "j", "k", "l") //创建数据集1
        val rdd4 = rdd1.zip(rdd2)

        rdd4.foreach(x =>print(x.toString()+" "))
        //(1,a) (2,b) (3,c) (4,d) (5,e) (6,f)
        println()

        val rdd5 = rdd1.zip(rdd2).zip(rdd3)
        rdd5.foreach(x =>print(x.toString()+" "))
        //((1,a),g) ((2,b),h) ((3,c),i) ((4,d),j) ((5,e),k) ((6,f),l)
        println()

        val rdd4_key = sc.parallelize(rdd4).keys
        rdd4_key.foreach(x =>print(x.toString()+" "))
        //1 2 3 4 5 6 

        sc.stop()
    }
}