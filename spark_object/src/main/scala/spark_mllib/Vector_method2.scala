package spark_mllib

import org.apache.spark.mllib.linalg.Vectors

object Vector_method2 extends App{
    override def main(args: Array[String]): Unit = {
        //稠密向量 DenseVector
        val denseVector = Vectors.dense(1.0, 0.0, 3.0)
        //稀疏向量 SparseVector
        val sparseVector = Vectors.sparse(100, Array(0, 2, 5), Array(1.0, 3.0, 8.0))

//        println("稠密向量: " + denseVector)

        println("稀疏向量: " + sparseVector)
//
        println("稠密向量转成稀疏向量： " + denseVector.toSparse)
//
        println("稀疏向量转成稠密向量： " + sparseVector.toDense)
    }
}