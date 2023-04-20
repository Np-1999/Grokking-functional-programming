package chapter2purefunctions

object practicisingPureFunctions extends App {
  def getTipPercentage(guests: List[String]): Int = {
    if (guests.length > 5) {
      20
    }
    else if (guests.nonEmpty) {
      10
    }
    else {
      0
    }
  }
  println(getTipPercentage(List("Alice", "Bob")))
  println(getTipPercentage(List("Alice", "Bob", "p", "q", "r", "s")))
  println(getTipPercentage(List.empty))
}
