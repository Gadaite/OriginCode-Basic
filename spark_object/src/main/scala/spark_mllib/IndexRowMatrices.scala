package spark_mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.IndexedRowMatrix
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.mllib.linalg.distributed.IndexedRow

object IndexRowMatrices extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd_1 = sc.textFile("/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D04/RowMatrix.txt")
        //文件转为向量
        val vd = rdd_1.map(x =>x.split(' ').map(_.toDouble)).map(line =>Vectors.dense(line)) 
        val vd_row = vd.map(x =>new IndexedRow(x.size,x))//转化格式：RDD[IndexedRow]
        val vd_row_index = new IndexedRowMatrix(vd_row)//建立索引行矩阵实例：IndexedRowMatrix

        //打印类型：
        println(vd_row_index.getClass())
        /**
          * class org.apache.spark.mllib.linalg.distributed.IndexedRowMatrix
          */
        
        //打印内容：
        println(vd_row_index.rows.foreach(println))
        /**
          * IndexedRow(3,[1.0,2.0,3.0])
            IndexedRow(3,[4.0,5.0,6.0])
          */
        
        //IndexedRowMatrix 可以直接转换成其他矩阵
        vd_row_index.toRowMatrix() // 转成行矩阵
        vd_row_index.toCoordinateMatrix() // 转成坐标矩阵
        vd_row_index.toBlockMatrix() // 转成块矩阵

        sc.stop()
        
    
    }
}