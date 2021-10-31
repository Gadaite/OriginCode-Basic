package spark_rdd

import org.apache.spark.sql.SparkSession

object rdd_five extends App{
    override def main(args: Array[String]): Unit = {
        /**
          * key-value RDD
          * pair RDD
          * 2021-10-31
          */
        val p = "-----"*20
        val spark = SparkSession.builder.appName("five").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        val rdd_1 = sc.parallelize(Seq("hadoop","java","scala","python","spark","linux","scala","python"))
        println(rdd_1.getClass())
        println(p)//class org.apache.spark.rdd.ParallelCollectionRDD

        //创建键值对RDD
        val rdd_1_1 = rdd_1.map(x=>(x,1))
        println(rdd_1_1.getClass())
        println(p)//class org.apache.spark.rdd.MapPartitionsRDD

        println(rdd_1_1.collect().foreach(x=>print(x)))
        println(p)
        /**
          * (hadoop,1)(java,1)(scala,1)(python,1)(spark,1)(linux,1)(scala,1)(python,1)
          */

        //reduceByKey(func)合并具有相同键的值
        rdd_1_1.reduceByKey((x,y)=>x+y).foreach(x=>println(x))
        println(p)
        /**
          * (scala,2)
            (python,2)
            (linux,1)
            (java,1)
            (spark,1)
            (hadoop,1)
          */

        //groupByKey()对具有相同键的值进行分组
        rdd_1_1.groupByKey().foreach(x=>println(x))
        print(p)
        /**
          * (scala,CompactBuffer(1, 1))
            (python,CompactBuffer(1, 1))
            (linux,CompactBuffer(1))
            (java,CompactBuffer(1))
            (spark,CompactBuffer(1))
            (hadoop,CompactBuffer(1))

          */

        // combineByKey( createCombiner, mergeValue, mergeCombiners, partitioner)
        // 使用不同的返回类型合并具有相同键的值
        
        //mapValues(func)对pair RDD 中的每个值应用一个函数而不改变键
        rdd_1_1.mapValues(x=>x+2).foreach(println)
        println(p)
        /**
          * (java,3)
            (scala,3)
            (python,3)
            (spark,3)
            (linux,3)
            (scala,3)
            (python,3)
          */
        
        //flatMapValues(func)对pair RDD 
        // 中的每个值应用一个返回迭代器的函数，
        // 然后对返回的每个元素都生成一个对应原键的键值对记录
        rdd_1_1.flatMapValues(x=>(x to 3)).foreach(println)
        println(p)
        /**部分结果如下
          * (java,3)
            (scala,1)
            (scala,2)
            (scala,3)
            (python,1)
            (python,2)
            (python,3)

          */

        //返回一个仅包含键的RDD rdd.keys()
        rdd_1_1.keys.collect().foreach(println)
        println(p)
        /**
          * hadoop
            java
            scala
            python
            spark
            linux
            scala
            python
          */
        
        //返回一个仅包含值的RDD rdd.values()
        rdd_1_1.values.collect().foreach(println)//8行1
        println(p)

        //返回一个根据键排序的RDD rdd.sortByKey()
        val rdd_2 = sc.parallelize(Seq(("hadoop",1),("Spark",2),("Java",3),("pyspark",2)))
        rdd_2.sortByKey().collect().foreach(println)
        println(p)
        /** 逆序使用：sortByKey(false)
          * (Java,3)
            (Spark,2)
            (hadoop,1)
            (pyspark,2)
          */

        //针对连个键值对RDD的操作

        //subtractByKey删掉 RDD 中键与 other RDD 中的键相同的元素
        val rdd_a = sc.parallelize(Seq((1, 2),(3, 4),(3, 6)))
        val rdd_b = sc.parallelize(Seq((3,9)))
        rdd_a.subtractByKey(rdd_b).foreach(println)//(1,2)
        println(p)

        //join对两个 RDD 进行内连接
        rdd_a.join(rdd_b).foreach(println)
        println(p)
        /**
          * (3,(4,9))
            (3,(6,9))
          */

        //rightOuterJoin对两个 RDD 进行连接操作，确保第一个 RDD 的键必须存在（右外连接）
        rdd_a.rightOuterJoin(rdd_b).foreach(println)
        println(p)
        /**
          * (3,(Some(4),9))
            (3,(Some(6),9))
          */

        //leftOuterJoin对两个 RDD 进行连接操作，确保第二个 RDD 的键必须存在（左外连接）
        rdd_a.leftOuterJoin(rdd_b).foreach(println)
        println(p)
        /**
          * (1,(2,None))
            (3,(4,Some(9)))
            (3,(6,Some(9)))
          */
        
        //cogroup将两个 RDD 中拥有相同键的数据分组到一起
        rdd_a.cogroup(rdd_b).foreach(println)
        println(p)
        /**
          * (1,(CompactBuffer(2),CompactBuffer()))
            (3,(CompactBuffer(4, 6),CompactBuffer(9)))
          */
        
        spark.stop()
        sc.stop()
        spark.close()


    }
}