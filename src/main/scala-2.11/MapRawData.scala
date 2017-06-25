/**
  * Created by dorinastratulat on 2017-06-21.
  */
object MapRawData extends Serializable {
  def mapRawLine(line: String): Option[LogSchema] = {
    try {
      val fields = line.split(",", -1).map(_.trim)
      Some(
        LogSchema(
          address = fields(0),
          datetime = fields(1).substring(13, 15),
          action = if (fields(2).length > 2) Some(fields(2)) else None
        )
      )
    }
    catch {
      case e: Exception =>
        //log.warn(s"Unable to parse line: $line")
        None
    }
  }

}
