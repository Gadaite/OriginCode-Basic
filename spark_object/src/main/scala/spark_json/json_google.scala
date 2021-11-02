package spark_json


import com.google.gson.JsonParser
import org.apache.spark.sql.SparkSession
object json_google extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("app").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        println("-----"*20)

        //从json文件转换成json字符串
        val jsonfile_rdd = sc.textFile("/root/Github_files/spark_object/python_All/Dataset/google.json")
        val jsonfile_rdd_rows = jsonfile_rdd.collect().length
        val json_str = jsonfile_rdd.collect().reduce((x,y) =>x+y).split(" ").reduce((x,y) =>x + " "+y)
        println(json_str)
        println("-----"*20)

        //解析json字符串中的内容
        val parser = new JsonParser()
        val jread = parser.parse(json_str).getAsJsonObject() 

        val bicycle_color = jread.get("store").getAsJsonObject().get("bicycle").getAsJsonObject().get("color").getAsString()
        println(bicycle_color)//red
        println("-----"*20)

        val book_isbn = jread.get("store").getAsJsonObject().get("book").getAsJsonArray().get(1).getAsJsonObject().get("isbn").getAsString()
        println(book_isbn)
        println("-----"*20)

        val book_price = jread.get("store").getAsJsonObject().get("book").getAsJsonArray().get(0).getAsJsonObject().get("price").getAsString()
        println(book_price)
        println("-----"*20)

    }
}