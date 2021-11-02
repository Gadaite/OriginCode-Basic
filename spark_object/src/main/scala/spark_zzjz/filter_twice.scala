package spark_zzjz


import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import scala.collection.mutable.ArrayBuffer
import org.apache.spark.sql.Row
object filter_twice extends App{
    override def main(args: Array[String]): Unit = {

        val spark = SparkSession.builder.appName("APP").master("local[*]").getOrCreate()
        val sc = spark.sparkContext

        import spark.implicits
        import spark.sql
        val condition_df =sql("""select * from `"+zzjzRddName+"_other`""")//此处不可用"来包含字符串会出现匹配问题
        val indf = sql("select * from `筛选one复件1_xWX1BKB5`")
        indf.createOrReplaceTempView("temp_tf")



        //解析条件参数
        var ret = ArrayBuffer[String]()
        val res = condition_df.collect()(0)
        println(res(0))//imsi=12
        println(res(0).getClass())//class java.lang.String
        println(res(0).toString().length())//2
        //剔除空的筛选条件
        if(res(0).toString().length()!=0){
            ret.append("Bobject_id")
            ret.append(res(0).toString())
        }
        if(res(1).toString().length()!=0){
            ret.append("gjdq")
            ret.append(res(1).toString())
        }
        if(res(2).toString().length()!=0){
            ret.append("company")
            ret.append(res(2).toString())
        }
        if(res(3).toString().length()!=0){
            ret.append("username")
            ret.append(res(3).toString())
        }
        if(res(4).toString().length()!=0){
            ret.append("importancelevel")
            ret.append(res(0).toString())
        }
        println(ret.length)
        //生成sql语句
        var str_original="select * from temp_df where "
        println(ret(0))
        println(ret(1))
        for(i<- 0 until ((ret.length)/2)) {
        str_original = str_original + "`" + ret(2*i) + "`" + "=" + "'" + ret(2*i+1) +"'" +" and "
        }
        //拿到字符串的总长度，为之后截断做准备
        println(str_original.length())
        val str_result = str_original.substring(0,str_original.length()-4)
        //println(str_original)
        println(str_result)
        sql("select * from `temp_df`").show
        val outdf = sql(str_result)
        outdf.show()
        // outputRDD("<#rddtablename#>",outdf)
    }
}