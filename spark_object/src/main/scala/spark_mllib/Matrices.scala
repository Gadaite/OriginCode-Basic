package spark_mllib

import org.apache.spark.mllib.linalg

object Matrices extends App{
    override def main(args: Array[String]): Unit = {
        val Matricess = linalg.Matrices.dense(3,4,Array(1,2,3,4,5,6,7,8,9,10,11,12))
        println(Matricess)
        /**
          * 1.0  4.0  7.0  10.0  
            2.0  5.0  8.0  11.0  
            3.0  6.0  9.0  12.0 
        */
    }
}