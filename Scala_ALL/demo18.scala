object demo18{
     //定义抽象类
        abstract class Shape{
            //抽象方法
            def area():Double
        }
        //正方形
        class Square(var edge:Double) extends Shape {
            override def area():Double=edge*edge
        }
        //矩形
        class Rectangle(var length:Double,var wide:Double) extends Shape{
            override def area():Double = length*wide
        }
        //圆形
        class Circle(var radius:Double) extends Shape{
            override def area():Double = Math.PI*radius*radius
        }
        //定义抽象匿名内部类
        abstract class Person{
            //定义抽象方法
            def printlnInfo()
        }
    def main(args:Array[String]){
        val square = new Square(15.00)
        val rectangle = new Rectangle(3.2,4.4)
        val circle = new Circle(2.5)
        //打印计算面积
        println(s"Square:${square.area()}")
        println(s"Rectangle:${rectangle.area()}")
        println(s"Circle:${circle.area()}")
 
        //匿名内部类创建对象
        val person = new Person{
            override def printlnInfo() = println("hello scala")
        }
        person.printlnInfo()
 
    }
}