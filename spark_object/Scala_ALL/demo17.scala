object demo17{
    //创建父类：
    class Person{
        val name:String = ""
        def getName() = this.name
    }
    //创建子类：
    class Student extends Person{
        //重写字段
        override val name:String = "student"
        //重写方法
        override def getName() = "add_"+super.getName()
    }
    def main(args:Array[String]){
        //子类调用父类方法.字段
        val Xiaobao =new Student
        val chuyu:Person = new Student//创建对象，指定为Person类型
        //判断对象是否为指定的类型使用isinstanceOf，
        if(Xiaobao.isInstanceOf[Student]){
            //将对象转换成指定类型转换：使用asInstenceOf
            val Xiaobaotemp = Xiaobao.asInstanceOf[Student]
            println(s"$Xiaobaotemp")
        }else{
            println("incorrect")
        }
        //比较isInstanceOf和getClass的区别
        println("---"*50)
        if(chuyu.isInstanceOf[Person]){
            //判断类型
            println(s"${chuyu} belongs to Person,using isInstanceOf")
        }else{
            println(s"${chuyu} not belongs to Person,using isInstanceOf")
        }
        if(chuyu.getClass == classOf[Person]){//getClass获取对象类型，classOf获取类的类型
            //判断类型
            println(s"${chuyu} belong to Person,using getClass")
        }else{
            println(s"${chuyu} not belongs to Person,using is getClass")
        }
        if(chuyu.getClass == classOf[Student]){
            //判断类型
            println(s"${chuyu} belongs to Student,using getClass")
        }else{
            println(s"${chuyu} not belongs to Student,using getClass")
        }
    }
}