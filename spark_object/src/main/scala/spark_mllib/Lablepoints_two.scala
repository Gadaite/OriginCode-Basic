package spark_mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.util.MLUtils

object Lablepoints_two extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        /**
          * 原始数据：
          * 1 1:2 2:3 3:4
            2 1:5 2:8 3:9
            1 1:7 2:6 3:7
            1 1:3 2:2 3:1
          */

        // 数据集标记index是从1开始的，从0开始报错
        val mu = MLUtils.loadLibSVMFile(sc, "/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D04/loadLibSVMFile.txt")
        mu.foreach(println)
        /**
          * 结果数据：
          * (1.0,(3,[0,1,2],[2.0,3.0,4.0]))
            (2.0,(3,[0,1,2],[5.0,8.0,9.0]))
            (1.0,(3,[0,1,2],[7.0,6.0,7.0]))
            (1.0,(3,[0,1,2],[3.0,2.0,1.0]))
          */
    }
}