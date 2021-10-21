object demo1{
  import scala.collection.mutable.ArrayBuffer//导入变长数组模块
  import scala.collection.mutable.ListBuffer//导入可变列表模块
  import scala.collection.mutable.Set
  def main(args: Array[String]) {
//数组
    val ArrayA = ArrayBuffer[Int]()
    val ArrayB = ArrayBuffer("python","scala","java","C#")
    for(i<-ArrayB) println(i)
    //增加一个数据：
    ArrayB+="hadoop"
    println(ArrayB)
    //减少一条数据：
    ArrayB-="C#"
    println(ArrayB)
    //追加数组进入：
    ArrayB++=Array("C","MatlaArrayB","SAS")
    println(ArrayB)
    //修改元素：
    ArrayB(0)="PYTHON"
    println(ArrayB)
    //遍历数组for：
    for(i<-0 to ArrayB.length-1){
      print(ArrayB(i)+",")
    }
    println()
    for(i<-0 until ArrayB.length){
      print(ArrayB(i)+",")
    }
    println()
    ArrayA++=Array(1,4,3,9,11,6)//合并
    println(ArrayA.sum,ArrayA.max,ArrayA.min)//最大，最小，求和
    println(ArrayA.sorted)//升序
    println(ArrayA.sorted.reverse)//降序
 
 
//元组tuple
    val tupleA =(1,"yanyi",23,"chengdu")
    val tupleB = "xiaoArrayBao" -> 22
    //访问元组元素:元组是个整体，遍历需要使用迭代器：
    for(item <- tupleA.productIterator){
      println(item)
    }
//列表
    //不可变列表
    val list1 = (1,2,3,4,5)
    val list2 = Nil//创建空列表
    val list3 = "hello"::"world"::Nil//两个元素的列表
    println(list3)
    //可变列表
    val list4 = ListBuffer[Int]()
    val list5 = ListBuffer(1,2,3,4,5,6,7,8,9)
    println(list5+=81)
    list5 ++= List(82,83,84)
    println(list5)
    //转换为不可变列表,数组
    val temp1 = list5.toList
    val temp2 = list5.toArray
    println(temp1.getClass,temp2.getClass)
 
//可变集
    val setA = Set(1,2,3,4,5)
    setA +=10//不保证插入位置
    setA -= 1
    
  }
}