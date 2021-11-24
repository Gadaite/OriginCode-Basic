package others

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.functions
import org.apache.spark.sql.types._
import java.util

object test1 extends App{
    override def main(args: Array[String]): Unit = {
        val spark =  SparkSession.builder().appName("app").master("local[*]").getOrCreate()
        val sc =spark.sparkContext
        val rdd = sc.parallelize(Array(
            Row("ming", 20, 15552211521L),
            Row("hong", 19, 13287994007L),
            Row("zhi", 21, 15552211523L)
        ))
        val schema = StructType(List(
            StructField("name",StringType),
            StructField("age",IntegerType),
            StructField("phone",LongType)
        ))
        val df = spark.createDataFrame(rdd,schema)
        df.show()
        println("-------"*20)
        def trans(x:String) ={
            var y =""
            if(x.toString() == "ming"){
                y = "M".toString()
            }
            if(x.toString() == "hong"){
                y = "H".toString()
            }
            if(x.toString() == "zhi"){
                y = "Z".toString()
            }
            y
        }
        val udf_en2zh = functions.udf(trans(_:String),StringType)
        df.withColumn("rename",udf_en2zh(df.col("name"))).createTempView("tmp")
        val res = spark.sql("""select rename as name,age,phone from tmp""")
        res.show()


             
            
        
    }
}