package spark_dataframe


import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import scala.collection.mutable.ArrayBuffer
import org.apache.spark.sql.Row
/**
  * @yanyyi
  * 2021-10-29
  */
object dataframe_one extends App{
    val spark = SparkSession.builder.appName("APP").master("local[*]").getOrCreate()
    val sc = spark.sparkContext
    /**
        第一个算子部分，把从界面输入的参数转换成一个DataFrame
    **/
    //定义模拟前面传入的dataframe
    val imsi =12//界面参数输入IMSI
    val col1 = "TW"//界面参数输入country_region
    val col2 = ""//界面参数输入company
    val col3 = ""//界面参数输入username
    val col4 = ""//界面参数输入importancelevel
    val seqinput = Seq(Row(imsi.toString(),col1,col2,col3,col4))
    val schema = StructType(List(
        StructField("imsi",StringType),
        StructField("col1",StringType),
        StructField("col2",StringType),
        StructField("col3",StringType),
        StructField("col4",StringType)
    ))
    val condition_rdd = sc.parallelize(seqinput)
    val condition_df = spark.createDataFrame(condition_rdd,schema)
    condition_df.show()

    /**
      * +----+----+----+----+----+
        |imsi|col1|col2|col3|col4|
        +----+----+----+----+----+
        |  12|  TW|    |    |    |
        +----+----+----+----+----+

      * 
      */

    /**
      * 导入待筛选的数据表,此处模拟生成,以2020-10-23号数据为例
      */


    val dfCsv = spark.read.format("csv")
    .option("header", true)
    .load("/root/Github_files/spark_object/python_All/Dataset/lastappearedmore_Data.csv")
    dfCsv.show()
    dfCsv.createOrReplaceTempView("temp_df")

    /**
      * 第二个算子部分，把这个前面获取的dataframe解析下来，
        并生成一个sql语句，通过sql语句对需要筛选的对象进行筛选
      */
    var ret = ArrayBuffer[String]()
    val res = condition_df.collect()(0)
    // println(res(0))//imsi=12
    // println(res(0).getClass())//class java.lang.String
    // println(res(0).toString().length())//2
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
    // println(ret.length)//6
    //生成sql语句
    var str_original="select * from temp_df where "
    // println(ret(0))//Bobiect_id
    // println(ret(1))//12
    for(i<- 0 until ((ret.length)/2)) {
      str_original = str_original + "`" + ret(2*i) + "`" + "=" + "'" + ret(2*i+1) +"'" +" and "
    }
    //拿到字符串的总长度，为之后截断做准备
    // println(str_original.length())//92
    val str_result = str_original.substring(0,str_original.length()-4)
    // println(str_original)//select * from temp_df where `Bobject_id`='12' and `gjdq`='TW' and `username`='zhangsan' and 
    // println(str_result)//select * from temp_df where `Bobject_id`='12' and `gjdq`='TW' and `username`='zhangsan' 

    // import spark.implicits
    // import spark.sql
    val outputdf = spark.sql(str_result)
    outputdf.show()

    spark.stop()
    spark.close()
    
} 