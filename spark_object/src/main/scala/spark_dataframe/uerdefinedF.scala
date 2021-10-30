package spark_dataframe

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._ 
import org.apache.spark.sql.functions
object uerdefinedF extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("app").master("local[*]").getOrCreate()
        val sc =spark.sparkContext
        println("hello spark,now coding!!")
        //从数据库读取数据，为dataframe
        val mysqldf = spark.read.format("jdbc").option("driver","com.mysql.cj.jdbc.Driver")
            .option("url","jdbc:mysql://139.155.70.177:3306/Gadaite")
            .option("user","root")
            .option("password","zzjz123")
            .option("dbtable","bmw")
            .load()
        //查看数据
        mysqldf.show()
        //注册临时表
        mysqldf.createOrReplaceTempView("bmw")
        //通过sql语句对表进行查询，结果展示，以及赋值
        spark.sql("""
            select * from bmw limit 10
            """).show()
        spark.sql("""
            select distinct(model) as model_size from bmw 
            """).show()
        val part_5 =spark.sql("""
            select * from bmw where model =" 5 Series"
            """)
        part_5.show()
        /*
            第一次执行并没有结果，怀疑是存在首位空格等多种情况,
            但是前面的distinct去重结果(只显示20行)中也没有    5 Series
            打印一下表的结构，来确认一下
        */
        //查看去重结果中是否真的不存在该内容
        //step1；保存前面查询到的去重的model字段的dataframe
        val distinct_model = spark.sql("select distinct(model) as model_size from bmw")
        val models_name = distinct_model.collect()//转为一行行的Row
        models_name.foreach(line =>print(line(0).toString() +","))
        //再取出其中的内容
        // val 
        // val model_infos = 
        mysqldf.printSchema()//结构确定数据字段并没有问题
        
        spark.stop()
        sc.stop()
    }
} 

