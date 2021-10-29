import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions
object dataframe_three extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("APP").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        val mysqldf = spark.read.format("jdbc")
        .option("driver","com.mysql.cj.jdbc.Driver")
        .option("url","jdbc:mysql://139.155.70.177:3306/Gadaite")
        .option("dbtable","footbresults")
        .option("user","root")
        .option("password","zzjz123")
        .load()
        //mysqldf.show()
        mysqldf.createOrReplaceTempView("table")
        spark.sql("""
            select * from table limit 4
            """).show()

        val ten_info = spark.sql("""
            select * from table limit 10
            """)
        ten_info.show()
        
        //显示定义函数
        def func1(a:Any,b:Any):Int ={
            return a.toString().toInt+b.toString().toInt
        }
        //隐式定义函数
        def func2(a:Int,b:Int) ={
            a+b
        }
        val func1_udf = functions.udf(func1(_:Int,_:Int),IntegerType)
        val res_df = ten_info.withColumn("sum",func1_udf(ten_info.col("home_score"),ten_info.col("away_score")))
        res_df.show()
        sc.stop()
        spark.stop()
    }
}