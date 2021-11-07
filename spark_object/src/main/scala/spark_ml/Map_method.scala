package spark_ml

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
object Map_method extends App{
    override def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("app").setMaster("local[*]")
        val sc = new SparkContext(conf)
        def func1(x:Int):Int={
            if(x%2==0){
                return x*x
            }
            else{
                return x*x*x
            }
        }
        val rdd = sc.parallelize(Array(1,2,3,4))
        val rdds = rdd.map(x => func1(x))
        rdds.foreach(x => print(x.toString()+" "))
        //1 4 27 16 

    }
}