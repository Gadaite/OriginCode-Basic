object demo10{
    //定义类的时候直接可以构造
    class Person(var name:String = "",var age:Int = 0){
        println("调用主构造器")       
    }
    def main(args:Array[String]){
        //创建xiaobao对象
        val xiaobao = new Person(name="xiaobao",age=20)
        println(xiaobao.name,xiaobao.age)
        println("-------")
        //创建空对象，使用默认值
        val empty = new Person()
        println(empty.name,empty.age)
        println("-------")
        //只传入一个参数
        val xiaoB = new Person(age = 40)
        println(xiaoB.name,xiaoB.age)
        println("-------")
    }
}