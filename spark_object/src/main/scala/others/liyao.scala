package others

import org.apache.spark.sql.SparkSession
// import org.apache.spark.mllib.classification.svc.{SVCModel, SVCModelParam}
import org.apache.spark.mllib.feature.StandardScaler
import org.apache.spark.mllib.linalg.Vectors
// import org.apache.spark.mllib.optimization.smo.kernel.{LinearFunction, PolyFunction, RBFFunction}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.rdd.RDD
import org.apache.spark.sql
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.types.{DoubleType, StructField, StructType}
object  liyao extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder().appName("app").master("local[*]").getOrCreate()
        val sc =spark.sparkContext
        val rdd = sc.parallelize(List(1,2,3,4,5,6))
        print(rdd.collect().foreach(x =>print(x.toString()+" ")))
    }
}