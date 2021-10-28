object demo11{
    //定义类的时候直接可以构造
    class Customer(var name:String = "",var address:String = ""){
        println("使用主构造器")   
        //定义辅助构造器,接收数组参数，使用数组初始化：
        def this(data:Array[String]){
            //辅助构造器第一行必须调用主构造器或其他辅助构造器
            this(data(0),data(1))
            println("调用主构造器")
        }
    }
    def main(args:Array[String]){
        //辅助构造器创建xiaobao对象
        val Xiaobao = new Customer(Array("xiaobao","beijing"))
        println(Xiaobao.name,Xiaobao.address)
    }
}