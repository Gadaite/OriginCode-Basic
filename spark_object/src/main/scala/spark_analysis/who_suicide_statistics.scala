package spark_analysis

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import com.mysql.cj.xdevapi.Schema
object who_suicide_statistics extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("app").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        val inputdf = spark.read.format("jdbc")
            .option("driver","com.mysql.cj.jdbc.Driver")
            .option("url","jdbc:mysql://139.155.70.177:3306/Gadaite")
            .option("dbtable","who_suicide_statistics")
            .option("user","root")
            .option("password","zzjz123")
            .load()
        // inputdf.show()
        inputdf.createOrReplaceTempView("who_suicide_statistics")
        // import spark.implicits
        // import spark.sqlContext
        spark.sql("select count(*) as All_rows from who_suicide_statistics").show()
        //打印结构
        inputdf.printSchema()
        //数据预处理:剔除空值处理
        val data1 = spark.sql("""select * 
            from who_suicide_statistics 
            where 
            `country` is not null 
            and `year` is not null 
            and `sex` is not null 
            and `suicides_no` is not null 
            and `population` is not null
            """)
        data1.createOrReplaceTempView("data1_view")
        spark.sql("""
            select count(*) as count_one from data1_view
            """).show()
        //分割训练数据与预测数据集
        //step1:dataframe转为rdd
        val data_rdd = data1.rdd
        //step2:对rdd添加索引
        val new_rdd = data_rdd.map(x => x.toString().substring(1,x.toString().length - 1)).zipWithIndex()
        //step3:rdd转为dataframe
        // val datasource = spark.createDataFrame(new_rdd,Schema = List(""))
    }
}