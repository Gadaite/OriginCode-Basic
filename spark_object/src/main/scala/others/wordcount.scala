package others

import org.apache.spark.sql.SparkSession

object  wordcount extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("app").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        val rdd = sc.textFile("/root/Github_files/spark_object/python_All/Dataset/Vegetable-carrots.txt")
        rdd.foreach(x =>println(x.toString()+" "))
        println("------"*20)
        val res = rdd.flatMap(x => x.split(" ")).map(x =>(x,1)).reduceByKey(_+_)
        res.foreach(res =>println(res.toString()+" "))

    }
}