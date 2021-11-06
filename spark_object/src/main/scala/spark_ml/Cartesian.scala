package spark_ml

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
object Cartesian extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rddone = sc.parallelize(Array(1,2,3,4,5,6,7))
        val rddtwo = sc.parallelize(Array(11,12,13,14,15,16,17))

        //计算笛卡尔积
        val rdd = rddone.cartesian(rddtwo)
        
        //打印输出结果
        rdd.foreach(x => print(x.toString()+" "))
        /**
          * (1,11) (1,12) (1,13) (2,11) (2,12) (2,13) (3,11) 
            (3,12) (3,13) (1,14) (1,15) (1,16) (1,17) (2,14) 
            (2,15) (2,16) (2,17) (3,14) (3,15) (3,16) (3,17) 
            (4,11) (4,12) (4,13) (5,11) (5,12) (5,13) (6,11) 
            (6,12) (6,13) (7,11) (7,12) (7,13) (4,14) (4,15) 
            (4,16) (4,17) (5,14) (5,15) (5,16) (5,17) (6,14) 
            (6,15) (6,16) (6,17) (7,14) (7,15) (7,16) (7,17) 
          */
    }
}