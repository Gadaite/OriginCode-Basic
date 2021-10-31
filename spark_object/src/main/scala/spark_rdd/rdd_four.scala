package spark_rdd

import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

object rdd_four extends App{
    override def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder.appName("four").master("local[*]").getOrCreate()
        val sc = spark.sparkContext
        val rdd_1 = sc.parallelize(Seq((1),(4,5,6,7,10,12,13,14,15,16,17),(7,8,12,9),(10,11,12)))

        val ss = "-----"*20
        //take(number)
        val res1 = rdd_1.take(2).foreach(x=>println(x))
        println(ss)
        /**
          * 1
          * (4,5,6,7,10,12,13,14,15,16,17)
          */
        
        //top(number),需要顺序
        val rdd_2 = sc.parallelize(Seq(1,3,5,7,2,4,8,0))
        val res2 = rdd_2.top(2).foreach(x=>println(x))
        println(ss)
        /**
          * 8
          * 7
          */
        
        //takeOrdered(umber)顺序与top相反
        val res3 = rdd_2.takeOrdered(3).foreach(x=>println(x))
        println(ss)
        /**
          * 0
          * 1
          * 2
          */
        //countByValue()统计元素出现个数
        val rdd_4 = sc.parallelize(Seq(1,3,5,7,2,3,3,1,7,1,1,1,1))
        val s = rdd_4.countByValue()
        println(s)//Map(5 -> 1, 1 -> 6, 2 -> 1, 7 -> 2, 3 -> 3)
        println(ss)

        //takeSample(withReplacement, num, [seed]),返回任意num个元素
        println(rdd_4.takeSample(false,2).foreach(x=>print(x.toString()+",")))
        println(ss)

        //aggregate(zeroValue)(seqOp, combOp),通常返回不同类型的函数,其他代码已经提及

        //persist()持久化，解决连续输出每次都需要提交整个流程
        /**
          * val NONE = new StorageLevel(false, false, false, false)
            val DISK_ONLY = new StorageLevel(true, false, false, false)
            val DISK_ONLY_2 = new StorageLevel(true, false, false, false, 2)
            val MEMORY_ONLY = new StorageLevel(false, true, false, true)
            val MEMORY_ONLY_2 = new StorageLevel(false, true, false, true, 2)
            val MEMORY_ONLY_SER = new StorageLevel(false, true, false, false)
            val MEMORY_ONLY_SER_2 = new StorageLevel(false, true, false, false, 2)
            val MEMORY_AND_DISK = new StorageLevel(true, true, false, true)
            val MEMORY_AND_DISK_2 = new StorageLevel(true, true, false, true, 2)
            val MEMORY_AND_DISK_SER = new StorageLevel(true, true, false, false)
            val MEMORY_AND_DISK_SER_2 = new StorageLevel(true, true, false, false, 2)
            val OFF_HEAP = new StorageLevel(true, true, true, false, 1)
          */

    }
}