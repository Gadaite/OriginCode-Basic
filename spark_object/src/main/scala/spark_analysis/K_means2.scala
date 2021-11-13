package spark_analysis


import java.util
import org.apache.spark.ml.clustering.KMeansModel
import org.apache.spark.ml.linalg
import org.apache.spark.ml.linalg.{SQLDataTypes, Vectors}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.types.{StructField, StructType}

object K_means2 extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession
            .builder
            .master("local")
            .appName("KmeansTest")
            .getOrCreate()

        val model = KMeansModel.load("model/kmeans")

        //中心点位置...
        model.clusterCenters.foreach(println)

        //测试数据...将这些数据进行"分类.."
        val testData = util.Arrays.asList(
            Row(Vectors.dense(Array(-0.1, 0.0, 0.0))),
            Row(Vectors.dense(Array(9.0, 9.0, 9.0))),
            Row(Vectors.dense(Array(3.0, 2.0, 1.0)))
        )

        val schema = StructType(List(
            StructField("features", SQLDataTypes.VectorType, nullable = false)
        ))

        val df = spark.createDataFrame(testData,schema)

        val result = model.transform(df)

        result.show()

        spark.close()
    }
}