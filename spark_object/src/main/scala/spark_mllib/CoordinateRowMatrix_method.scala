package spark_mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.distributed.MatrixEntry
import org.apache.spark.mllib.linalg.distributed.CoordinateMatrix

object CoordinateRowMatrix_method extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd = sc.textFile("/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D04/RowMatrix.txt")
        
        //将RDD转为坐标格式
        val rdds = rdd.map(x =>x.split(" ").map(x =>x.toDouble)).map(line =>(line(0).toLong,line(1).toLong,line(2)))

        //转成坐标矩阵格式
        val rddss = rdds.map(line => new MatrixEntry(line _1,line _2,line _3))

        //实力话坐标举证

        val rdd_res = new CoordinateMatrix(rddss)

        println(rdd_res.entries.foreach(println))
        

    }
}