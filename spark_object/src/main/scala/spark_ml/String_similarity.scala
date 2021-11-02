package spark_ml


import breeze.linalg.max
import breeze.numerics.sqrt
import com.google.gson.JsonParser
import org.apache.spark.api.java.StorageLevels
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{DoubleType, StructField}
import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.sql.SparkSession
object String_similarity extends App{
    override def main(args: Array[String]): Unit = {
        
        val spark = SparkSession.builder.master("local[*]").appName("app").getOrCreate()
        val sc = spark.sparkContext
        /** 计算最长公共子序列相似度 */
        def LCS(s1: String, s2: String): Double = {
            if(s1.length==0||s2.length==0) return 0
            val res = Array.ofDim[Int](s1.length+1,s2.length+1)
            for(m<-1 to s1.length){
            for(n<- 1 to s2.length){
                if(s1.charAt(m-1)==s2.charAt(n-1))res(m)(n)=res(m-1)(n-1)+1
                else res(m)(n)=max(res(m - 1)(n) , res(m)(n - 1))
            }
            }
            2.0*res(s1.length)(s2.length)/(s1.length+s2.length)
        }
        /** 计算未归一化的字符串核相似度 */
        def SSK(s1: String, s2: String,len:Int,Lambda:Double): Double = {
            if(len==0)return 1
            if(s1.length==0||s2.length==0||len>s1.length||len>s2.length) return 0
            val n1=s1.length
            val n2=s2.length
            var dp1=Array.ofDim[Double](n1+1,n2+1).map(row=>{row.map(x=>x+1)})
            val answer: Array[Double] =new Array[Double](len)
            for(l <- 0 until len){
            val dp2=Array.ofDim[Double](n1+1,n2+1)
            var res:Double=0
            for(i<-1 to n1){
                for(j<-1 to n2){
                dp2(i)(j)+=dp2(i-1)(j)*Lambda+dp2(i)(j-1)*Lambda-dp2(i-1)(j-1)*Lambda*Lambda
                if(s1(i-1)==s2(j-1)){
                    dp2(i)(j)+=dp1(i-1)(j-1)*Lambda*Lambda
                    res=res+dp1(i-1)(j-1)*Lambda*Lambda
                }
                }
            }
            dp1=dp2.clone()
            answer(l)=res
            }
            answer(len-1)
        }
        /** 计算归一化后的字符串核相似度 */
        def normalizeSSK(s1: String, s2: String,len:Int,Lambda:Double):Double={
            if(len==0)return 1
            if(s1.length==0||s2.length==0||len>s1.length||len>s2.length) return 0
            val ssk1=SSK(s1,s1,len,Lambda)
            val ssk2=SSK(s2,s2,len,Lambda)
            val ssk12=SSK(s1,s2,len,Lambda)
            ssk12/sqrt(ssk1*ssk2)
        }
        
        val jsonparam = "<#zzjzParam#>"
        println(jsonparam)
        val parser = new JsonParser()
        val rootNode = parser.parse(jsonparam).getAsJsonObject

        /** 加载数据 */
        val firstCol = rootNode.get("firstCol").getAsJsonArray.get(0).getAsJsonObject.get("name").getAsString
        val secondCol = rootNode.get("secondCol").getAsJsonArray.get(0).getAsJsonObject.get("name").getAsString
        val method =rootNode.getAsJsonObject("method").get("value").getAsString
        val colName =rootNode.get("colName").getAsString
        val inputRDD = sc.textFile("/root/Github_files/spark_object/python_All/Dataset/Vegetable-carrots.txt")
        val dfTable = rootNode.get("Tablename").getAsString
        val df: DataFrame = inputRDD.asInstanceOf[org.apache.spark.sql.DataFrame]

        /** 相似度计算 */
        val outputDF: DataFrame =method match{
            case "levenshtein"=>{
                //levenshtein
                df.withColumn(colName,lit(1) - levenshtein(col(firstCol), col(secondCol)) /
                    greatest(length(col(firstCol)), length(col(secondCol))))
            }
            case "LCS"=>{
                //LCS
                val rowrdd: RDD[Row] =df.rdd.map(row=>{
                Row.merge(row,Row(LCS(row.getAs[String](firstCol),row.getAs[String](secondCol))))
                })
                val schema=df.schema.add(StructField(colName,DoubleType,true))
                spark.createDataFrame(rowrdd,schema)
            }
            case "SSK"=>{
                //SSK

                val len:Int=rootNode.getAsJsonObject("method").get("len").getAsString.toInt
                val Lambda:Double=rootNode.getAsJsonObject("method").get("lambda").getAsString.toDouble

                val rowrdd: RDD[Row] =df.rdd.map(row=>{
                Row.merge(row,Row(normalizeSSK(row.getAs[String](firstCol),row.getAs[String](secondCol),len, Lambda)))
                })
                val schema=df.schema.add(StructField(colName,DoubleType,true))
                spark.createDataFrame(rowrdd,schema)
            }
        }
        outputDF.show()
    }
}