import org.apache.spark.sql.SparkSession
object  dataframe{
    
        val spark = SparkSession.builder().master("local[*]").getOrCreate()
        import spark.implicits
        val Array_1 = (Seq(1,2,3),Seq(4,5,6),Seq(7,8,9))
        val rdd_1 = spark.sparkContext.parallelize(Array_1)
        val df = spark.createDataFrame(rdd_1,("A","B","C"))        
    
}