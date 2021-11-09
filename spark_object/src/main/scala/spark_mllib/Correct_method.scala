package spark_mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.stat.Statistics

object Correct_method extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc  = new SparkContext(conf)
        val rdd1 = sc.textFile("/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D04/testCorrectX.txt",1)
        val rddx = rdd1.flatMap(x=>x.split(" ").map(x=>x.toDouble))
        rddx.foreach(x =>print(x+" "))
        println()
        //1.0 2.0 3.0 4.0 5.0 


        val rdd2 = sc.textFile("/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D04/testCorrectY.txt",1)
        val rddy = rdd2.flatMap(x =>x.split(" ").map(x =>x.toDouble))
        rddy.foreach(x =>print(x+" "))
        println()
        //2.0 4.0 6.0 8.0 10.0 


        //计算相关系数
        val Correlation = Statistics.corr(rddx,rddy)
        println(Correlation)
        //0.9999999999999998

        //计算协方差需要相同的分区数和分区个数，且每个分区个数上的元素的个数需要相同

    }
}