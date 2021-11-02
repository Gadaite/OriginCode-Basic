package others

object SplitAndReduce extends App{
    override def main(args: Array[String]): Unit = {
        val str1 = "hello       Spark, hello   Scala"
        val str1_1 = str1.split(" ").reduce((x,y) => x+" "+y)
        val str1_2 = str1.split(" ").map(x =>x+" ").reduce((x,y) =>x+y)
        println(str1_1)
        println(str1_2)
    }
}