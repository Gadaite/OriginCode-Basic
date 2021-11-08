package spark_mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.RowMatrix

object RowMatrices extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        /**
         * 行矩阵
         * 行矩阵是以行作为基本方向的矩阵存储格式，列的作用相对较小。可以将其理解为行矩阵是一个巨大的特征向量的集合。
         * 每一行就是一个具有相同格式的向量数据，且每一行的向量内容都可以单独取出来进行操作
         */
        val rdd_1 = sc.textFile("/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D04/RowMatrix.txt")
        /**
          * 原始数据：
          * 1 2 3
            4 5 6
          */
        val rdd_2 = rdd_1.map(_.split(' ').map(_.toDouble))//RDD[Array[Double]]
        val rdd_3 = rdd_2.map(line =>Vectors.dense(line))//RDD[linalg.Vector]
        val rm = new RowMatrix(rdd_3)

        println(rm.numRows()) //打印列数:2
        println(rm.numCols()) //打印行数:3      
     
    }
}