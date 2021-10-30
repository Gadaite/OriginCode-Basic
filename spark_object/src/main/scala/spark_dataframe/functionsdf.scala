package spark_dataframe


import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions
import org.apache.spark.sql
object functionsdf extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("APP").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        val inputdf = spark.read.format("csv").option("header",true).load("/root/Github_files/spark_object/python_All/Dataset/iris-data.csv")
        inputdf.show()
        def func1(x:Any,y:Any):Double ={
            return x.toString().toDouble * y.toString().toDouble
        }
        // import spark.implicits
        // import spark.sqlContext
        val func1_udf = functions.udf(func1(_:Any,_:Any),DoubleType)
        val func1_df1 = inputdf.withColumn("sepal-area",func1_udf(inputdf.col("sepal-length"),inputdf.col("sepal-width")))
        func1_df1.show()
        func1_df1.printSchema()
        val func1_df2 = func1_df1.withColumn("petal-area",func1_udf(func1_df1.col("petal-length"),func1_df1.col(" petal-width")))
        func1_df2.show()
        //other method defined udf_function
        
        val func3 =(x:Any,y:Any) =>{
            val sums = 2*(x.toString.toDouble) + 2*(y.toString.toDouble)
            sums.toDouble.toString()
        }
        val func3_udf = functions.udf(func3,StringType)

        /**     以下定义也可以实现
          *     val func3_udf = functions.udf(func3(_:Any,_:Any),StringType)
          */
        
        val func3_df3 = inputdf.withColumn("sepal-range",func3_udf(inputdf.col("sepal-length"),inputdf.col("sepal-width")))
        func3_df3.show()
        spark.stop()
        sc.stop()

    }
}