object demo7{
//1.定义一个类
    class Person{
        //如果类是空的，可以省略{}
        //eg:class Person()
        //2.定义成员变量
        var name:String = ""
        var age:Int = 0
        
    }
    def main(args:Array[String]){
        val person = new Person()
        //如果类是空的，可以省略()
        //eg:val person = new Person
        //println(person) ouput:demo6$Person@548c4f57
        //3.创建对象，访问成员，设置变量值
        person.name = "zhangsan"
        person.age = 20
        println(person.name)
        println(person.age)
    }
}