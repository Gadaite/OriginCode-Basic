package spark_analysis

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LinearRegressionWithSGD

object M1_LinearRegression extends App{    
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        val datasource = sc.textFile("/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D06/lr.txt")
        println(datasource.getNumPartitions)
        datasource.foreachPartition(x =>{
            x.foreach(y =>println(y.toString()+" "))
        })

        println("-----"*20)
        //对数据进行格式化清理
        val data_clean = datasource.map(line =>{
            val part = line.split("|")
            LabeledPoint(part(0).toDouble,Vectors.dense(part(1).split(" ").map(x =>x.toDouble)))
        }).cache()

        //打印分区内的数据集
        data_clean.foreachPartition(part =>{
            part.foreach(x =>println(x.toString()+" "))
        })
        println("-----"*20)

        //建立模型
        val model = LinearRegressionWithSGD.train(data_clean, 200, 0.1)
        val prediction = model.predict(data_clean.map((_.features)))
        //检验测试集数据
        prediction.foreach(obj => println(obj)) //打印原测试集数据使用模型后得出的结果
        println("-----"*20)
        // println(model.predict(Vectors.dense(0,1))) //提供新的待测数据
            
    }
}