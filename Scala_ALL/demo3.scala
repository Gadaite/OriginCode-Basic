object demo3{
    def main(args:Array[String]){
        /*不可变集部分*/
//定义不可变集
        val set1 = Set[Int]()
        val set2 = Set(1,1,12,3,4,5,745,77,3)
        println(set2)//自动移除重复元素，且不保证插入顺序
//获取集的大小
        val size = set2.size
//遍历集的元素
        for(i<-set2){
            print(i.toString+" ")
        }
        println()
//删除元素
        val temp1 =set2-745
        val temp2 =set2+999
        println(temp1)
        println(temp2)
//拼接另一个集
        val set3 =Set(21,22,23,24)
        val set4 =set2++set3
        println(set4)
//拼接列表
        val set5 =set2++List(31,32,33,34)
        println(set5)
        println(set5.getClass)
 
        /*可变集部分*/
        {
            import scala.collection.mutable.Set
            val setA = Set(1,2,3,4,5)
            setA+=6
            setA-=1
            println(setA)
            println(setA.getClass)
        }
 
    }
}