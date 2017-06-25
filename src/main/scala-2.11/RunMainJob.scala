import org.apache.spark.rdd.RDD
import org.apache.spark.{Logging, SparkConf, SparkContext}
import org.joda.time.DateTime


object RunMainJob {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("spark-loganalyzer")
      .setMaster("local[*]")
    // local mode
    val sc = new SparkContext(conf)
    val startTimeJob = new DateTime(sc.startTime)
    val applicationId = sc.applicationId
    // log.info("Application launched with id : " + applicationId)
    println("Application launched with id : " + startTimeJob)

    val rawData: RDD[String] = sc.textFile("/Users/dorinastratulat/myprojects/SparkEx1/src/main/resources/ApacheLog")
    val numberOfRawLines = rawData.count()
    println(s"count rows : $numberOfRawLines")

    val parseData: RDD[LogSchema] = rawData.flatMap(x => MapRawData.mapRawLine(x))

    println(s"Number of lines after parsing: ${parseData.count()}")

    TransformMapper.transform(parseData)
  }
}
