package spark_analysis

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LinearRegressionWithSGD

object M2_LinearRegression extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val datasource = sc.textFile("/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D06/lr.txt")
        val parsedData = datasource.map { line => //开始对数据集处理
            val parts = line.split('|') //根据逗号进行分区
            LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(',').map(_.toDouble)))
        }.cache() //转化数据格式
        val model = LinearRegressionWithSGD.train(parsedData, 2, 0.1) //建立模型
        val valuesAndPreds = parsedData.map { point => { //获取真实值与预测值
                val prediction = model.predict(point.features) //对系数进行预测
                (point.label, prediction) //按格式存储
            }
        }

        val MSE = valuesAndPreds.map { case (v, p) => math.pow((v - p), 2) }.mean() //计算MSE
        println(MSE)
    
    }
}