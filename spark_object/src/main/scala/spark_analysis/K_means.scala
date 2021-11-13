package spark_analysis

import org.apache.spark.ml.clustering.{KMeans, KMeansModel}

import org.apache.spark.ml.linalg.{ SQLDataTypes, Vectors}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types._
import org.apache.spark.sql._


object K_means extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("app").master("local[*]").getOrCreate()
        val data = spark.sparkContext.textFile("/root/Github_files/spark_object/python_All/Dataset/kmeans_data.txt")
        //数据转换
        val rdd = data.map(s => Row(Vectors.dense(s.split(' ').map(_.toDouble))))
        //声明结构
        val schema = StructType(List(
            StructField("features", SQLDataTypes.VectorType, nullable = false)
        ))
        //创建dataframe
        val df = spark.createDataFrame(rdd,schema)
        df.show()

        //导入kmeans
        val kmeans= new KMeans()
        //聚类的个数
        kmeans.setK(3)
        //最大迭代次数
        kmeans.setMaxIter(20)
        //随机种子...
        kmeans.setSeed(1L)

        val model: KMeansModel = kmeans.fit(df)

        //中心点位置....
        model.clusterCenters.foreach(println)

        //评估模型的好坏，使用平方欧式距离测度
        val errors: Double = model.computeCost(df)

        println("平方误差: " + errors)

        model.save("model/kmeans")

        spark.close()



    }
}