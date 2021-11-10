package spark_mllib

import scala.collection.mutable.HashMap
import shapeless.the

object SDG_method extends App{
    override def main(args: Array[String]): Unit = {

        val xx = 1 -> 10
        println(xx)

        /**
          * (1,10)
          */

        
        //生成数据
        val data = HashMap[Int,Int]()
        //生成数据集内容
        def getData():HashMap[Int,Int] = {
            for(i <-1 to 7){
                data += (i -> (3 * i)) //写入公式y=3x
            }
            data.foreach{
                case (a,b) =>print(a+" -> "+b)
                println()
            }
            data
        }
        // getData()
        /**
          * 2 -> 6
            5 -> 15
            4 -> 12
            1 -> 3
            3 -> 9
            6 -> 18
          */
        //第一步假设为0
        var theta = 0.toDouble
        //设置步长
        var alpha = 0.1
        //定义迭代公式
        def sdg(x:Double,y:Double) ={
            theta = theta - alpha*((theta *x) -y)
        }
        
        val datasource = getData()
        datasource.foreach(item =>{
            sdg(item._1,item._2)
            println("当前theta值： "+theta)
        })

        //最终结果：
        println("最终theta值： "+theta)//2.81856
        
        /**
          * (1,10)
            2 -> 6
            5 -> 15
            4 -> 12
            7 -> 21
            1 -> 3
            3 -> 9
            6 -> 18
            当前theta值： 0.6000000000000001
            当前theta值： 1.8000000000000003
            当前theta值： 2.2800000000000002
            当前theta值： 2.7840000000000003
            当前theta值： 2.8056
            当前theta值： 2.8639200000000002
            当前theta值： 2.945568
            最终theta值： 2.945568
          */


    }
}