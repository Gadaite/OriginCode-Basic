package spark_analysis

import org.apache.spark.sql.SparkSession

object KNN extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder().appName("app").master("local[*]").getOrCreate()
        val inputdf = spark.read.format("jdbc")
            .option("driver","com.mysql.cj.jdbc.Driver")
            .option("url","jdbc:mysql://139.155.70.177/Gadaite")
            .option("user","root")
            .option("password","zzjz123")
            .option("dbtable","diabetes")
            .load()
        
        // inputdf.show()
        inputdf.createOrReplaceTempView("datasource")
        val count_rows = spark.sql("""select count(*) from datasource""").collect()(0)(0).toString().toInt
        println(count_rows)//768行

        //定义距离函数
        // def distance()       

    }
}