package `spark_rdd.scala`

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._ 
import org.apache.spark.sql.functions
object wordcount extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("myapp").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        val rdd_words = sc.textFile("/root/Github_files/spark_object/python_All/Dataset/My_Internship_Experience.txt")
        val array = rdd_words.collect()
        array.foreach(x=>println(x))
        val result = rdd_words.flatMap(lines =>lines.split(" "))
                .map(word =>(word,1)).reduceByKey((x,y) => x+y).sortBy(_._2)
        //println(result.collect().foreach(println))
        val most_10 = result.collect().toArray.reverse.slice(0,10)
        most_10.foreach(println)

        sc.stop()
        spark.stop()
    }
}