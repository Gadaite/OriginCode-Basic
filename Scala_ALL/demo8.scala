object demo8{
//1.定义一个类
    class Custom{
        //定义成员变量
        var name:String = _
        var sex:String = _
        //定义成员方法
        def printHello(msg:String):Unit=println(msg)
    }
    def main(args:Array[String]){
        val custom = new Custom()
        custom.printHello("hello boy!")
    }
}