package spark_mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.recommendation.Rating
import org.apache.spark.mllib.recommendation.ALS

object CollaborativeFilter extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)

        /**
         * 基于ALS算法的协同过滤推荐
         * MLlib中ALS算法有固定的数据格式    Rating:元组类型的[Int,Int,Double]
         */
        
        //设置数据集
        val rdd = sc.textFile("/root/Github_files/spark_object/src/main/resources/DataSet_sparklearn/D05/u1.txt")
        val ratings = rdd.map(x => x.split(" ")
            match {
                case Array(a,b,c) =>{
                    Rating(a.toInt,b.toInt,c.toInt)
                }
            }
        )//val ratings: RDD[Rating]
        //设置隐藏因子
        val rank = 2
        //设置迭代次数
        val iter = 2
        //进行模型训练
        val model = ALS.train(ratings,rank,iter,0.01)
        //根据已有数据集建立协同过滤模型后用recommendProducts为第二个用户推荐一个商品
        var rs = model.recommendProducts(2, 1) //为用户2推荐一个商品
        rs.foreach(println) //打印结果

        /**
         * 为第二个用户推荐了编号为15的商品，同时将预测评分3.94进行输出，与实际值4相差较小
         */
        //Rating(2,15,3.8716001044821624)



        

    }
}