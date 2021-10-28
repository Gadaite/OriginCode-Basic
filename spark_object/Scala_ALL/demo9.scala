object demo9{
    class Person{
        //定义成员变量,可以使用类型推断
        private var name = ""
        private var age = 0
        //定义成员方法,未声明为public
        def getname() = this.name
        def setname(name:String) = this.name=name
        def getage() = this.age
        def setage(age:Int) = this.age=age
        private def getnameAndage()={
            (this.name,this.age)
        }
    }
    def main(args:Array[String]){
        val person = new Person()
        person.setname("xiaobao")
        person.setage(21)
        println(person.getname(),person.getage())
    }
}