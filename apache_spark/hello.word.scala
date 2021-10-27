import org.apache.spark.sql.SparkSession
object Main  {
  def main(args: Array[String]) = {
    println("hello scala!")
    val ss = SparkSession.builder
      .appName("example")
      .master("local")
      .getOrCreate()
      import ss.implicits._
      ss.createDataset(1 to 10).show()
      ss.close()
  }
}