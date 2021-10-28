object demo2{
    def main(args:Array[String]){
        val listA=List(1,2,3,4,5)
//判断列表是否为空：
        println(listA.isEmpty)
//拼接两个列表：
        val listB=List(90,91,92,93)
        println(listA++listB)
//获取列表的首个元素和剩余部分：
        println(listB.head)//获取首个元素
        println(listB.tail)//除了第一个元素以外的元素
//反转列表：
        val listC=listA.reverse
        println(listC)
//获取列表的前缀和后缀：
        val listD=List(9831,12378,172837,173987,6474,4375)
        println(listD.take(3))//获取前面3个
        println(listD.take(2))
        println(listD.drop(4))//除去前面4个剩余部分
        println(listD.drop(2))
//扁平化操作：
        val list1 = List(List(1,2),List(3),List(4,5,6))
        println(list1)
        println(list1.flatten)
//拉链与拉开：
        //两个列表合成一个列表，内容为元组
        val list_1 =List("name1","name2","name3")
        val list_2 =List(18,17,20)
        println(list_1.zip(list_2))
        //元组列表解开为两个列表
        val list_turple = list_1.zip(list_2)
        println(list_turple.unzip)
//转换字符串：
        val list_3 =List(11,12,13,14)
        val to_Str =list_3.toString()
        println(to_Str(0).getClass)
//生成字符串：
        println(list_3.mkString)
        println(list_3.mkString("---"))
//并集，交集，差集：
        val list_test1 =List(1,3,5,7,9)
        val list_test2 =List(4,5,6,7,8)
        //并集
        println(list_test1.union(list_test2))//union取并集并不去重
        println(list_test1.union(list_test2).distinct)//去重使用distinct
        //交集
        println(list_test1.intersect(list_test2))//intersect交集
        //差集
        println(list_test1.diff(list_test2))//a.diff(b),a中除去与b的交集
    }
}