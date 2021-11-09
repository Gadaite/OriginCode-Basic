package spark_mllib

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object StratifiedSampling extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf() //创建环境变量
            .setMaster("local") //设置本地化处理
            .setAppName("testSingleCorrect2 ") //设定名称
        val sc = new SparkContext(conf) //创建环境变量实例
        val data = sc.textFile("/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D04/testStratifiedSampling.txt")
            .map(row => { //开始处理
                if (row.length == 3) //判断字符数
                    (row, 1) //建立对应map
                else (row, 2) //建立对应map
            }).map(each => (each._2, each._1))
        /**
          * 原始数据：
            aa
            bb
            cc
            dd
            ee
            aaa
            bbb
            ccc
            ddd
            eee
          */

        data.foreach(println)
        /**
          * 结果展示：
            (2,aa)
            (2,bb)
            (2,cc)
            (2,dd)
            (2,ee)
            (1,aaa)
            (1,bbb)
            (1,ccc)
            (1,ddd)
            (1,eee)
          */
        println("sampleByKey:")
        val fractions: Map[Int, Double] = (List((1, 0.2), (2, 0.8))).toMap //设定抽样格式
        val approxSample = data.sampleByKey(withReplacement = false, fractions, 0) //计算抽样样本
        approxSample.foreach(println)
        /**
          * (2,bb)
            (2,cc)
            (2,ee)
          */

        println("Second:")
        val randRDD = sc.parallelize(List((7, "cat"), (6, "mouse"), (7, "cup"), (6, "book"), (7, "tv"), (6, "screen"), (7, "heater")))
        val sampleMap = List((7, 0.4), (6, 0.8)).toMap
        val sample2 = randRDD.sampleByKey(false, sampleMap, 42).collect
        sample2.foreach(println)
        /**
          * (6,screen)
            (7,heater)
          */

        println("Third:")
        val a = sc.parallelize(1 to 20, 3)
        val b = a.sample(true, 0.8, 0)
        val c = a.sample(false, 0.8, 0)
        println("RDD a : " + a.collect().mkString(" , "))
        println("RDD b : " + b.collect().mkString(" , "))
        println("RDD c : " + c.collect().mkString(" , "))
        /**
          * RDD a : 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 11 , 12 , 13 , 14 , 15 , 16 , 17 , 18 , 19 , 20
            RDD b : 2 , 4 , 5 , 6 , 10 , 14 , 19 , 20
            RDD c : 1 , 2 , 4 , 6 , 7 , 8 , 9 , 10 , 11 , 12 , 13 , 14 , 15 , 16 , 17 , 19
          */
        sc.stop

    //val fractions: Map[String, Double] = Map("aa" -> 2) //设定抽样格式
    //val approxSample = data.sampleByKey(withReplacement = false, fractions, 0) //计算抽样样本
    //approxSample.foreach(println) //打印结果
    }
}