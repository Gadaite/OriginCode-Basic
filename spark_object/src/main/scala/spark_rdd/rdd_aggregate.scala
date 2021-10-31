package spark_rdd

import org.apache.spark.sql.SparkSession
object rdd_aggregate extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("four").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        val codelines = "-----"*20
        //reduce
        val list_a = List(1,2,3,4,5)
        println(list_a.reduce((x,y) => x+y))//15
        /**
          * 1+2+3+4+5=15
          */
        println(codelines)

        //aggregate 方法是一个聚合函数，接受多个输入，并按照一定的规则运算以后输出一个结果值
        val agg_rdd = sc.parallelize(1.to(5),1)
        println(agg_rdd.collect().foreach(x=>print(x.toString()+",")))
        println(codelines)

        def fun1(x:Int,y:Int) = {
            x+y
        }
        def fun2(x:Int,y:Int) = {
            x*y
        }
        val Init_value = 3//定义一个初始值
        val res_agg_1 = agg_rdd.aggregate(3)(fun1,fun2)//Int
        val res_agg_2 = agg_rdd.aggregate(3)(fun2,fun1)
        println(res_agg_1,res_agg_2)//54,363
        /**
          * 先使用fun1
          * 由初始值为3，依次计算3+1+2+3+4+5=18
          * 再使用fun2
          * 由初始值为3，依次计算18*3 =54
          * 
          * 
          * 
          * 3*1*2*3*4*5 =360
          * 360+3 =363
          */
        println(codelines)

        //对多个分区使用该算子
        val range_1 = 1.to(10)
        println(range_1.getClass())//class scala.collection.immutable.Range$Inclusive
        val aggs_rdd = sc.parallelize(1.to(10),2)
        println(codelines)

        //查看rdd分区
        aggs_rdd.collect().foreach(x=>println(x))
        println(aggs_rdd.getNumPartitions)
        println(codelines)

        aggs_rdd.foreachPartition(it =>{
            it.foreach(x=>print(x.toString()+","))
            println()
        })
        
        /**
          * 6,7,8,9,10,
          * 1,2,3,4,5,
          */
        val res_aggs = aggs_rdd.aggregate(2)(fun1,fun2)
        println(res_aggs)//1428
        /**
          * 初始值为2
          * 先使用func1函数分别在两个分区中
          * 2+1+2+3+4+5 =17
          * 2+6+7+8+9+10 =42
          * 再使用func2函数分别在两个分区中
          * 2*17*42 = 1428
          */
        
    }
}