package spark_files

import org.apache.spark.sql.SparkSession

object read_csv extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.master("local[*]").appName("app").getOrCreate()
        val sc = spark.sparkContext
        val inputdf = spark.read.format("csv")
            .option("hearder",true)
            .load("/root/Github_files/spark_object/python_All/Dataset/seeds_dataset.csv")
        inputdf.show()
        
    }
}