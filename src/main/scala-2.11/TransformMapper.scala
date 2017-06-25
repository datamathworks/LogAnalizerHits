import org.apache.spark.rdd.{RDD}
import org.apache.spark.SparkContext._

/**
  * Created by dorinastratulat on 2017-06-21.
  */
object TransformMapper {
  def transform(events: RDD[LogSchema]) = {
    val e = events.map(x => (x.datetime, 1)).reduceByKey (_ + _)
    e.saveAsTextFile("/Users/dorinastratulat/myprojects/SparkEx1/src/main/resources/test.txt")
  }


}
