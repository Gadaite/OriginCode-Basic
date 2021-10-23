import java.text.SimpleDateFormat
import java.util.Date
object demo13{
    //创建一个单例对象实现日期格式化工具类：
    object DateUtil{
        //1.创建一个DateUtil工具类
        //使用java的内库
        val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
        def format(date:Date) = simpleDateFormat.format(date)
    }
    def main(args:Array[String]):Unit={
        //测试访问单例对象方法
        val now = new Date()
        println(DateUtil.format(now))
        
    }
}