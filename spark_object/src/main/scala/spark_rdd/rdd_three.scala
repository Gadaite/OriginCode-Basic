package spark_rdd

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
object rdd_three extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder().appName("myapp").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        //创建rdd1
        val rdd_text = sc.textFile("/root/Github_files/spark_object/python_All/Dataset/Vegetable-carrots.txt")
        rdd_text.collect().foreach(x =>println(x))
        println("-----" *20)

        //创建rdd2
        val rdd_list = sc.parallelize(List("spark","I like Spark"))
        rdd_list.collect().foreach(x =>println(x))
        println("-----" *20)

        //rdd的转换操作时返回一个新的RDD eg: map,filter
        val rdd_map = rdd_list.map(x=>(x,1))
        rdd_map.collect().foreach(x =>println(x))
        println("-----" *20)

        val rdd_filter = rdd_text.filter(x =>x.contains("Ma")).collect().foreach(x => println(x))
        println("-----" *20)

        //rdd的行动操作,collect count 
        println(rdd_text.count())
        println("-----" *20)

        //向spark中传递函数
        def isMatch(str:String):Boolean = {
            str.contains("They")
        }
        rdd_text.map(x =>isMatch(x)).collect().foreach(x => println(x))
        /**结果终端显示如下，前面的数字代表个数，为什么显示如下呢？>>>>>>>>>>>>Q1
          * 2 false
          * 2 true
          * 2 false
          */
        //Q1-1:
        println("-----"*20)

        val Array = rdd_text.map(x =>isMatch(x)).collect()
        //查看一下数组长度
        println(Array.length)//返回结果是7
        //使用for循环遍历一下再次测试
        for (i<- 0 until Array.length){
            print(Array(i).toString() + ",")
        }
        /**
          * false,false,true,true,false,false,false,
          */
        println("-----"*20)

        //手动生成数据测试是否显示类似的结果
        val Brray = scala.Array[Boolean](false,false,true,true,false,false,false)
        Brray.foreach(m =>println(m))
        /**
          * 2 false
          * 2 true
          * 2 false
          */ //发现显示相同的结果，对重新生成一个数据，判断前面的数字是否是表示连续的个数
        println("-----"*20)

        val Crray = scala.Array[Boolean](false,true,false,true,true,true,false,false,true,false)
        Crray.foreach(n =>println(n))
        /**
          * false
            true
            false
            3 true
            2 false
            true
            false
          */ //那就是这个意思吧，不深究了
        println("-----"*20)

        // flatMap
        rdd_list.flatMap(x =>x.split(" ")).collect().foreach(x =>println(x))
        println("-----"*20)

        // map
        val list_temp1 = rdd_list.flatMap(x =>x.split(" "))
        val list_temp2 = list_temp1.map(a =>(a,"????"))
        list_temp2.collect().foreach(a =>println(a))
        println("-----"*20)

        //eg :计算rdd中各个值得平方
        //s1,单个
        val rdd_sq = sc.makeRDD(List(1,2,3))
        rdd_sq.map(a => a*a).collect().foreach(x =>println(x))
        val rdd_square = sc.parallelize(List(
            List(1,2,3),
            List(4,5,6),
            List(7,8,9)
        ))
        def square_func(s:List[Int])={
            val ss = s
            val ret = ss.map(m =>m*m)
            ret
            
        }

        //确定rdd.collect的类型
        println(rdd_square.collect()(0))
        println(rdd_square.collect().getClass())//Tuple
        println("----"*25)

        val square_temp = rdd_square.map(x =>square_func(x))
        square_temp.collect().foreach(x =>println(x))
        println("-"*100)

        //两个RDD的笛卡尔积
        val rdd_1 = sc.parallelize(List("A","B","C"))
        val rdd_2 = sc.parallelize(List(1,2,3))
        val rdd_1_cartesian_2 = rdd_1.cartesian(rdd_2).collect().foreach(x=>println(x))
        println("-----"*20)

        //RDD去重
        //s1.一行时
        val rdd_3 = sc.parallelize(List(1,2,3,4,5,5,6,3,5,64,1,2))
        rdd_3.distinct().collect().foreach(x=>println(x))
        println("-----"*20)

        //s2.多行时
        val rdd_4 = sc.parallelize(List(
            List(1,2,3),
            List(2,3,1),
            List(1,5,1)
        ))
        rdd_4.distinct().collect().foreach(x=>println(x))//并不会去重行，因为每行不一样
        println("-----"*20)
        rdd_4.map(x =>x.distinct).collect().foreach(x=>println(x))//这样才能去重每一行,但不能去重每一列
        println("-----"*20)

        //同时去重
        val rdd_5 = sc.parallelize(List(
            List(1,2,3),
            List(2,3,1),
            List(1,5,1),
            List(1,2,3)
        ))
        rdd_5.distinct().map(x =>x.distinct).collect().foreach(x=>println(x))
        println("-----"*20)

        //返回两个RDD都有的元素,同时移除单个中相同的元素
        val rdd_1_1 = sc.parallelize(List("A","B","C","A"))
        val rdd_6 = sc.parallelize(List("A","E","C","S"))
        rdd_1_1.intersection(rdd_6).collect().foreach(x=>println(x))
        println("-----"*20)

        //移除RDD中的某些数据，即为该RDD中除去与其他RDD的交集部分,查看原始RDD是否改变
        // rdd_1_1.subtract(rdd_6).collect().foreach(x =>println())
        // rdd_1_1.collect().foreach(x =>println())
        // println("-----"*20)

            /*上面使用 foreach 后显示被折叠了,使用循环打印一下*/
        //确定一下rdd_1长度
        println(rdd_1_1.collect().length)//4
        println("-----"*20)

        //结果
        val Array_sub = rdd_1_1.subtract(rdd_6).collect()
        for (item <- Array_sub) {
            println(item)
        }
        println("-----"*20)

        //原始rdd_1_1
        for (item <- rdd_1_1.collect()){
            println(item)
        }
        println("-----"*20)
        
        println("hello world")

        //元素个数
        println(rdd_1_1.collect().length)//4
        println("-----"*20)

        /**
          * 只读：不能修改，只能通过转换操作生成新的 RDD
          * 分布式：可以分布在多台机器上进行并行处理（在结果中可以看到RDD转换后生成的RDD并不一定按照原来的顺序）
          * 
          */





    }   

}