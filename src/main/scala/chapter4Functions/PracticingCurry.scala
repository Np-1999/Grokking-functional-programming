package chapter4Functions

object PracticingCurry extends App {
  def largerThan(n: Int)(i: Int): Boolean = { // First argument is explicitly passed in filter
    n < i
  }

  println(List(5, 1, 2, 4, 0).filter(largerThan(4)))

  def divisibleBy(n: Int)(i: Int): Boolean = {
    i % n == 0
  }

  println(List(5, 1, 2, 4, 15).filter(divisibleBy(5)))

  def shorterThan(n: Int)(word: String): Boolean = {
    word.length < n
  }
  println(List("scala", "ada").filter(shorterThan(4)))

  def containsS(n: Int)(word: String): Boolean = {
    word.count(x => if x == 's' then true else false) > n
  }
  println(List("scala", "ada").filter(containsS(2)))

}
