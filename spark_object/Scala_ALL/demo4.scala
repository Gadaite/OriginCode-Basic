object demo4{
    def main(args:Array[String]){
//不可变映射的两种定义方式：
        var map1 =Map("xiaobao"->23,"chuyu"->22,"59"->23)//不可变的Map结构
        var map2 =Map(("baobao",23),("cucu",22),("wuwu",23))//不可变的Map结构
        //通过key获取value的值
        println(map1("xiaobao"))
        println(map1.getClass)
//使用可变Map
        import scala.collection.mutable.Map
        val mapA =Map("zhangsan"->30,"lishi"->32)
        println(mapA.getClass)
        //修改value
        mapA("zhangsan")=29
        println(mapA)
 
 
//iterator迭代器：从集合获取一个迭代器
        val listA = List(1,2,3,4,5,6)
        val ite = listA.iterator//获取迭代器
//使用while表达式迭代
        while(ite.hasNext){
            print(ite.next.toString+" ")
        }
        //hasNext方法:查询容器是否有下一个元素
        //next方法：返回迭代器下一个元素，如果没有，抛出NoSuchElementException,每个迭代器都是有状态的
        println()
//使用for表达式迭代
        val listB = List(11,12,13,14,15,16)
        //需要重新定义一个迭代器
        val itr = listB.iterator
        for(i<-itr) print(i.toString+" ")
        println()
    }
}