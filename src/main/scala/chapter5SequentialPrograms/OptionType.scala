package chapter5SequentialPrograms

object OptionType extends App {
  case class Event(name: String, start: Int, end: Int)

  def validateName(name: String): Option[String] = {
    if (name.nonEmpty) Some(name) else None
  }

  def validateEnd(end: Int): Option[Int] = {
    if (end < 3000) Some(end) else None
  }

  def validateStart(start: Int, end: Int): Option[Int] = {
    if (start <= end) Some(start) else None
  }

  def validateLength(start: Int, end: Int, minLength: Int): Option[Boolean] = {
    if (end - start > minLength) Some(true)
    else {
      None
    }
  }
  def parse(name: String, start: Int, end: Int): Option[Event] = {
    for {
      validName <- validateName(name)
      validEnd <- validateEnd(end)
      validStart <- validateStart(start, end)
    } yield Event(validName, validStart, validEnd)
  }

  def parseLongEvent(name: String, start: Int, end: Int, minLength: Int): Option[Event] = {
    for {
      validLength <- validateLength(start, end, minLength)
      validName <- validateName(name)
      validEnd <- validateEnd(end)
      validStart <- validateStart(start, end)
    } yield Event(validName, validStart, validEnd)
  }
  println(parse("Apollo", 1961, 1972))
  println(parse("", 1939, 1945))
  println(parseLongEvent("Apollo Program", 1961, 1972, 10))
  println(parseLongEvent("World War II", 1939, 1945, 10))

}
