package spark_mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.linalg.Vectors

object SingleCorrect extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val arrayT = 1.to(20).toArray
        val rdd = sc.parallelize(arrayT,1)
        val rdds = rdd.map(x =>x.toDouble)
        val rddss = rdds.map(x =>Vectors.dense(x)) 

        //斯皮尔曼计算相关系数
        val corrres = Statistics.corr(rddss,"spearman")
        println(corrres)//1.0
    }
}