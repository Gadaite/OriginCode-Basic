package spark_analysis

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import com.mysql.cj.xdevapi.Schema
import org.apache.spark.sql.types._ 
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

        spark.sql("select * from who_suicide_statistics limit 10").show()
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
            limit 1000
            """)
        
        data1.createOrReplaceTempView("data1_view")
        spark.sql("""
            select count(*) as count_one from data1_view
            """).show()
        //分割训练数据与预测数据集
        //step1:dataframe转为rdd
        val data_rdd = data1.rdd.zipWithIndex()
        val data_train = data_rdd.filter(x => x._2%5 !=0).keys
        val data_test = data_rdd.filter(x => x._2%5 == 0).keys
        
        //获取dataframe的所有列数组
        val cols = data1.schema.fields

        //创建训练数据和预测数据的dataframe
        val train_dataset = spark.createDataFrame(data_train,StructType(cols))
        val test_dataset = spark.createDataFrame(data_test,StructType(cols))

        //查看数据集结构
        train_dataset.printSchema()
        test_dataset.printSchema()

        //查看数据集的行数
        println(train_dataset.count())
        println(test_dataset.count())
        
        //训练数据
        

    }
}