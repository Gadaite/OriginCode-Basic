import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
import java.util.Arrays;
import java.util.List;
public class SparkJavaAPIDemo{
    public static void main(String[] args) {
        //1.准备环境
        SparkConf sparkConf = new SparkConf().setAppName("SparkJavaAPIDemo").setMaster("local[*]");
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);
        jsc.setLogLevel("WARN");
        //2.加载数据
        JavaRDD<String> fileRDD = jsc.textFile("/root/Github_files/python_All/Dataset/Vegetable-carrots.txt");
        JavaRDD<String> wordsRDD = fileRDD.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        JavaPairRDD<String,Integer> wordAndOneRDD = wordsRDD.mapToPair(word -> new Tuple2<>(word, 1));
        JavaPairRDD<String, Integer> wordAndCountRDD = wordAndOneRDD.reduceByKey((a, b) -> a + b);
        List<Tuple2<String, Integer>> result = wordAndCountRDD.collect();       
        result.forEach(System.out::println);
    }
}
​


