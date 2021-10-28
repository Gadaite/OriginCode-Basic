object demo6{
    def main(args:Array[String]){
//foreach遍历：
        val listA = List(1,2,3,4,5)
        //foreach接收的是一个函数：其返回值是一个unit（空）类型
        println(listA.foreach((x:Int)=>print(x.toString+" ")))
    //使用类型推断简化函数定义：
        println(listA.foreach(x=>print(x.toString+" ")))
    //使用下划线简化函数定义：
        //函数参数只出现过一次的情况
        println(listA.foreach(print(_)))
 
//Map映射：
        //将数据类型转换，接收的也是一个函数，应用到每个元素，返回新的列表
        println(listA.map(a=>a*2+1))
        //使用’_‘简化时，需要注意使用条件，并省略’=>‘
        println(listA.map(_ * 3))
 
//flatMap扁平化映射
        //先Map再flatten
        //eg:提取多个列表中的单词：
        val listB = List("scala spark hadoop flink kafka","mysql orecle postgres hive mangodb")
        val temp1 = listB.map(_.split(" "))
        val listC = temp1.flatten       
        println(listC)
        //直接使用flatMap
        println(listB.flatMap(_.split(" ")))
 
//filter过滤
        val listD = List(1,2,3,4546,45745,879,324,114,1234,346,778,78,6)
        println(listD.filter(_%3==0))
 
//sortBy,sorted,sortWith
        val listF = List(1,2,3,4,4325,3643,141,346,785,1243,124,3124,124)
        //sorted排序
        println(listF.sorted)
        //sortBy对字段排序,如下按照单词
        val listG = List("01 hadoop","02 apple","03 zxvf")
        println(listG.sortBy(_.split(" ")(1)))
        //sorfWith自定义排序
        val listH = List(23,123,3245,456,67,532,131,7,97,21)
        println(listH.sortWith((x,y)=>if (x<y) true else false))
            //简化如下：
        println(listH.sortWith(_<_))
 
//groupBy分组：
        val listI = List("zhangsan"->"男","lisi"->"男","liyan"->"女")
        val temp2 = listI.groupBy(x=>x._2)
        println(temp2)
        println(temp2.map(x=>x._1 -> x._2.size))
        println((temp2.map(x=>x._1 -> x._2.size).toList))
//聚合操作reduce，fold：
        //reduce:将列表集合传入函数计算
        //reduce,reduceLeft,reduceRight
        val listJ = List(1,2,3,4,5,6,7,8,9,10)
        println(listJ.reduce((x,y)=>x+y))
        println(listJ.reduceLeft((_+_)))
        println(listJ.reduceRight(_+_))
        //fold:折叠
        //fold,foldLeft,foldRight
        println(listJ.fold(0)(_+_))//初始值为0，结果55
        println(listJ.fold(100)(_+_))//100为初始值，结果155
 
    }
}