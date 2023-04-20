package chapter3ImmutableValues

object PracticingImmutableSlicing extends App {

  def firstTwo(intialList: List[String]): List[String] = {
    intialList.slice(0, 2)
  }

  def lastTwo(intialList: List[String]): List[String] = {
    intialList.slice(intialList.length - 2, intialList.length)
  }

  def movedFirstTwoToTheEnd(intialList: List[String]): List[String] = {
    intialList.slice(2, intialList.length).appendedAll(firstTwo(intialList))
  }

  def insertedBeforeLast(intialList: List[String], toInsert: String): List[String] = {
    intialList
      .slice(0, intialList.length - 1)
      .appended(toInsert)
      .appendedAll(
        intialList
          .slice(intialList.length - 1, intialList.length)
      )
  }
  println(firstTwo(List("a", "b", "c")))
  println(lastTwo(List("a", "b", "c")))
  println(movedFirstTwoToTheEnd(List("a", "b", "c")))
  println(insertedBeforeLast(List("a", "b"), "c"))
}
