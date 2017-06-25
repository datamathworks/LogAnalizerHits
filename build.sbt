name := "ApacheSparkAnalyzer"

version := "1.0"

scalaVersion := "2.11.0"


libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "1.2.1",
  "joda-time" % "joda-time" % "2.9.9",
  "org.joda" % "joda-convert" % "1.8.1",
  "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test"
)