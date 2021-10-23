object demo12{
    //创建一个单例对象：
    object PrintUtil{
        //单例对象的成员变量
        val str = "hello xiaobao"
        //单例对象的成员方法
        def printline(){
            println("-"*15)
        }
 
    }
    def main(args:Array[String]){
        //测试访问单例对象方法,成员
        PrintUtil.printline()
        println(PrintUtil.str)
        
    }
}