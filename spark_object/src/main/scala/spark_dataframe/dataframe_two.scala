import org.apache.spark.sql.SparkSession
import scala.collection.mutable.ArrayBuffer
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.IntegerType
import com.mysql.cj.xdevapi.Schema
import org.apache.spark.sql.types.StringType

object dataframe_two extends App{
    override def main(args: Array[String]){
        val spark = SparkSession.builder.appName("app").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        //method 1
        val sseq = Seq(
            ("aa","bb","cc"),
            ("Aa","Bb","Cc"),
            ("AA","BB","CC")
        )
        val seq_df = spark.createDataFrame(sseq).toDF("A","B","C")
        seq_df.show()
        //method 2
        val csv_df1 = spark.read.format("csv").option("header",true).load("/root/Github_files/spark_object/python_All/Dataset/iris-data.csv")
        csv_df1.show()
        val csv_df2 = spark.read.format("csv").option("header",false).load("/root/Github_files/spark_object/python_All/Dataset/iris-data.csv")
        csv_df2.show()
        val csv_df3 = spark.read.format("csv").load("/root/Github_files/spark_object/python_All/Dataset/iris-data.csv")
        csv_df3.show()
        
        //mothod 3 动态创建dataframe
        val list = List((1,2,3),(4,5,6),(7,8,9))
        val rdd_list = sc.makeRDD(list)
        val schema = StructType(List(
            StructField("col1",StringType),
            StructField("col2",IntegerType),
            StructField("col3",StringType)
        ))
        val schema_df = spark.createDataFrame(rdd_list).withColumnRenamed("_1","AAA")
        schema_df.show()
        
        import java.util
        val arrayList = new util.ArrayList[Row]()
        arrayList.add(Row("xiaobao",21,"famale"))
        arrayList.add(Row("chuyu",23,"male"))
        arrayList.add(Row("5-9",24,"male"))
        val arrayList_df =spark.createDataFrame(arrayList,schema)
        arrayList_df.show()

        //mysql
        val mysqldf = spark.read.format("jdbc").option("driver","com.mysql.cj.jdbc.Driver")
            .option("url","jdbc:mysql://139.155.70.177:3306/Gadaite")
            .option("user","root")
            .option("dbtable","audi")
            .option("password","zzjz123")
            .load()
        mysqldf.show()

        spark.stop()
        spark.close()
        
    }
}

