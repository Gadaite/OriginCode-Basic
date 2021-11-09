package spark_mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.random.RandomRDDs.normalRDD

object RandomRDD extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val rdd = normalRDD(sc,20,4)
        /**
          * 4
          */
        println(rdd.getNumPartitions)
        rdd.foreachPartition(x =>{
            x.foreach(s =>print(s+","))
            println()
        })
        /**
          * -0.43476774082885283,0.08694121424487708,0.004531950836679043,-0.05192609762758044,0.8718599749172482,
            0.04064619093220043,-0.0949339506347614,-0.5175955505094741,1.577797160980029,-0.1772140854557522,
            -0.8114515325316612,-0.15621579892382528,1.3624755693951942,1.3888200983904404,0.21640507568435013,
            -0.9231179647185063,1.0393142342702277,0.33540504285266765,-2.657723659876138,0.6803840245620559,
          */
    }
}