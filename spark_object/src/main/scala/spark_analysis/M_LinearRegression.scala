package spark_analysis

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LinearRegressionWithSGD

object M_LinearRegression extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        //获取数据源
        val rdd_source = sc.textFile("/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D06/lpsa.data")
        val parsedData = rdd_source.map { line => //开始对数据集处理
            val parts = line.split(',') //根据逗号进行分区
            // 这里part(0)和part(1)分别代表y和x
            LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
        }.cache() //转化数据格式

        //打印分区情况：
        parsedData.foreachPartition(part =>{
            part.foreach(x =>print(x+" "))
            println()
        })
        //每个分区的结果：
        /**
          * (1.0,[0.0,1.0]) (2.0,[0.0,2.0]) (3.0,[0.0,3.0]) (5.0,[1.0,4.0]) 
          * (7.0,[6.0,1.0]) (9.0,[4.0,5.0]) (6.0,[3.0,3.0]) 
          */
        println("-----"*20)
        val numlterations = 100 // 整体模型的迭代次数，理论上迭代次数越多模型的拟合程度越高，迭代需要的时间越长

        val stepSize = 0.1 // 随机梯度下降算法中的步进系数，代表每次迭代过程中模型的整体修正程度

        val model = LinearRegressionWithSGD.train(parsedData, numlterations, stepSize)

        //建立模型
        val prediction = model.predict(parsedData.map((_.features)))

        // println("-----"*20)

        //检验测试集数据
        prediction.foreach(obj => println(obj)) //打印原测试集数据使用模型后得出的结果

        println("-----"*20)
        // 提供新的待测数据, Vectors.dense(0, 1) 人为创建一个MLlib数据向量输入到已构成的数据模型中
        println(model.predict(Vectors.dense(0, 1)))



    }
}