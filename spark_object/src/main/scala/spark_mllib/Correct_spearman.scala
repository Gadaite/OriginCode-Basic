package spark_mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.stat.Statistics

object Correct_spearman extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val arrayx = 1.to(10).toArray
        val rddx = sc.parallelize(arrayx,1).map(x =>x.toDouble)
        val arrayy = 23.to(32).toArray
        val rddy = sc.parallelize(arrayy,1).map(x =>x.toDouble) 

        //计算spearman相关系数
        val Correlation = Statistics.corr(rddx,rddy,"spearman")
        println(Correlation)
        //1.0000000000000009


        //计算相关系数
        val Correlations = Statistics.corr(rddx,rddy)
        println(Correlations)
        //1.000000000000001
      
    }
}