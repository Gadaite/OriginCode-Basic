object demo19{
    //创建特质：
    trait Logger{
        //特质中定义抽象方法
        def log(msg:String)
    }
    //实现类继承单个特质
    class ConsoleLogger extends Logger{
        override def log(msg:String) = println("Console output:" + msg)
    }
    
    //创建两个特质：
    trait MessageSender{
        def send(msg:String)
    }
    trait MessageReceiver{
        def receive()
    }
    //实现类继承两个特质：
    class MessageWorker extends MessageSender with MessageReceiver{
        override def send(msg:String) = println("sender message:"+msg)
        override def receive() = println("receice that message")
    }
 
    //单例对象继承特质
    object Loggerobject extends Logger{
        override def log(msg:String) = println(s"hello ${msg},using single object")
    }
    def main(args:Array[String]){
        //实现类的对象调用方法
        val logger = new ConsoleLogger
        logger.log("hello scala，using single trait")
 
        val messageWorker = new MessageWorker
        messageWorker.send("hello Scala!")
        messageWorker.receive()
 
        //单例对象调用方法
        Loggerobject.log("spark")
    }
}