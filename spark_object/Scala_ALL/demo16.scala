object demo16{
    //创建伴生类1：
    class CustomerService{
        def save(){
            println(CustomerService.service_name+":over!")
        }
    }
    //创建伴生对象1
    object CustomerService{
        //私有变量
        private val service_name = "CustomerService"
    }
 
    //创建伴生类2：
    //class Person(private[this] var name:String)//定义在主构造器上,但这种权限下不能执行
    class Person(private/*[this]*/ var name:String)//定义在主构造器上
    //创建伴生对象2
    object Person{
        def printperson(P:Person) = println(P.name)
    }
    
    def main(args:Array[String]):Unit={
        //1对象方法
        val customerService = new CustomerService
        customerService.save()
        //伴生对象伴生类能够互相访问私有成员和方法，但是限制权限则不行
        Person.printperson(new Person("xiaobao"))
        
    }
}