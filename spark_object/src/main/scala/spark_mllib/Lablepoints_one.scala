package spark_mllib

import org.apache.spark.mllib.linalg.{Vector,Vectors}
import org.apache.spark.mllib.regression.LabeledPoint
object Lablepoints_one extends App{
    override def main(args: Array[String]): Unit = {
        //建立密集向量
        val vd = Vectors.dense(2,0,6)
        //对密集向量建立标记点
        val pos = LabeledPoint(1,vd)
        //打印标记点信息
        println(pos.features)//[2.0,0.0,6.0]

        //打印既定标记
        println(pos.label)//1.0

        //建立稀疏向量
        val vs = Vectors.sparse(4,Array(0,1,2,3),Array(9,5,2,7))
        //对稀疏向量建立标记点
        val neg = LabeledPoint(2,vs)
        //打印标记点信息
        println(neg.features)//(4,[0,1,2,3],[9.0,5.0,2.0,7.0])
        //打印既定标记
        println(neg.label)//2.0


    }
}