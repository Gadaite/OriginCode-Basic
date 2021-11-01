// package spark_zzjz

// import com.jayway.jsonpath.JsonPath
// import com.zzjz.deepinsight.basic.BaseMain
// import org.joda.time.format.DateTimeFormat
// import org.apache.spark.sql.types._
// object MB_scearch extends App{
//     override def main(args: Array[String]): Unit = {
//         val jsonparam = "<#zzjzParam#>"
//         println(jsonparam)

//         //获取用户设置参数
//         val ctxRead = JsonPath.parse(jsonparam)

//         val id = ctxRead.read[String]("$.id")
//         val startTime = ctxRead.read[String]("$.time[0]")
//         val endTime = ctxRead.read[String]("$.time[1]")
//         val action =  ctxRead.read[String]("$.action")
//         val area =  ctxRead.read[String]("$.selectArea")


//         var typeString = ""
//         val len = ctxRead.read[Int]("$.types.length()")
//         if (len > 0){
//             typeString += ctxRead.read[String]("$.types[0].title")
//             for (i <- 1 until len){
//                 typeString += ("," + ctxRead.read[String]("$.types[" + i + "].title"))
//             }
//         }

//         val selectArea = 
//         if (area!=""){
//             val points = area.split(',')
//             points(0) + " " + points(1) + "," +
//             points(0) + " " + points(3) + "," +
//             points(2) + " " + points(3) + "," +
//             points(2) + " " + points(1) + "," +
//             points(0) + " " + points(1)
//         }
//         else ""


//         //将101.166,34.588,100.331,31.644中经纬度之间的,替换为空格
//         //     var flag = false
//         //     val tempStr = area.map(ch => {
//         //       if (ch==',') {
//         //         flag = !flag
//         //         if (flag) ' ' else ch
//         //       }
//         //       else ch
//         //     })
//         // val selectArea = tempStr + ',' + tempStr.substring(0, tempStr.indexOf(','))

//         val actionStr = if (action=="全部") "" else action

//         val arrayStructData = Seq(
//         Row(id, s"$startTime,$endTime", actionStr, typeString, selectArea)
//         )

//         val arrayStructSchema = StructType(List(
//         StructField("object_id", StringType),
//         StructField("lastmodified_time_range", StringType),
//         StructField("exception_type", StringType),
//         StructField("f0410_name", StringType),
//         StructField("lastoccur_region", StringType)
//         ))

//         val df = spark.createDataFrame(sc.parallelize(arrayStructData),arrayStructSchema)
//         df.printSchema
//         df.show

//         val rddTableName = """<#zzjzRddName#>"""
//         outputrdd.put(rddTableName, df)
//         df.createOrReplaceTempView(s"`${rddTableName}`")
//         sqlc.cacheTable(s"`${rddTableName}`")
//         // z.put("id", id)
//         // z.put("time", s"$startTime,$endTime")
//         // z.put("action", action)
//         // z.put("types", types)
//         // z.put("area", area)

//         val imsi = ctxRead.read[String]("$.imsi")
//         val col1 = ctxRead.read[String]("$.col1")
//         val col2 = ctxRead.read[String]("$.col2")
//         val col3 = ctxRead.read[String]("$.col3")
//         val col4 = ctxRead.read[String]("$.col4")
//         val arrayStructData_other = Seq(
//             Row(imsi,col1,col2,col3,col4)    
//         )
//         val arrayStructSchema_other = StructType(List(
//             StructField("imsi",StringType),
//             StructField("col1",StringType),
//             StructField("col2",StringType),
//             StructField("col3",StringType),
//             StructField("col4",StringType)
//         ))
//         val df_other = spark.createDataFrame(sc.parallelize(arrayStructData_other),arrayStructSchema_other)
//         df_other.printSchema()
//         df_other.show()
//         val rddTableName_other = """<#zzjzRddName#>_other"""
//         outputrdd.put(rddTableName_other,df_other)
//         df_other.registerTempTable(s"`${rddTableName_other}`")
//         sqlc.cacheTable(s"`${rddTableName_other}`")
//     }
// }