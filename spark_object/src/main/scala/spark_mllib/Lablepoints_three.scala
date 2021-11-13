package spark_mllib

import org.apache.spark.sql.SparkSession

object Lablepoints_three extends App{
    override def main(args: Array[String]): Unit = {

        /**
          *  创建LabelPoint(标注点)的两种方式：
        *    1.通过稀疏向量或稠密向量来创建LabelPoint
        *    2.通过加载LibSVM文件来创建
          */
        val spark = SparkSession.builder().appName("app").master("local[*]").getOrCreate()
        val data = spark.read.format("libsvm").load("/root/Github_files/spark_object/python_All/Dataset/健康状况训练集.txt")
        data.show()
        data.printSchema()
    }
}