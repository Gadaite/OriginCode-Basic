package spark_mllib

import org.apache.spark.mllib.linalg.Vectors

object Vector_method extends App{
    /**
     *向量（5.2，0.0，5.5）

      密集向量表示：[5.2，0.0，5.5]

      稀疏向量表示：（3，[0,2]，[5.2,5.5]）    
      3是向量（5.2，0.0，5.5）的长度，
      除去0值外，其他两个值的索引和值分别构成了数组[0,2]和数组[5.2,5.5]。
     */
    override def main(args: Array[String]): Unit = {
        val vd = Vectors.dense(2,0,6)//密集向量
        println(vd(2))//打印第3个值
        /**
          * 6.0
          */
        //建立稀疏向量
        val vs = Vectors.sparse(4,Array(0,1,2,3),Array(9,5,2,7))
        //打印稀疏向量的第三个值
        println(vs(2))
        /**
          * 2.0
          */
    }
}