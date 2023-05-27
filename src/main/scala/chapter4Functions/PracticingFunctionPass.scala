package chapter4Functions

object PracticingFunctionPass extends App {

  def byLength(A: String): Int = {
    A.length
  }

  def numberofS(A: String): Int = {
    A.count(x => if x == 's' then true else false)
  }

  def negativeNumberofS(A: String) = {
    -numberofS(A)
  }

  def negative(A: Int): Int = {
    -A
  }

  def sortList(sortFunction: String => Int, AList: List[String]): List[String] = {
    AList.sortBy(sortFunction)
  }

  def sortIntList(sortFunction: Int => Int, AList: List[Int]): List[Int] = {
    AList.sortBy(sortFunction)
  }

  val words = List("scala", "rust", "ada")
  println(sortList(byLength, words))

  val words2 = List("rust", "ada")
  println(sortList(numberofS, words2))

  val values = List(5, 1, 2, 4, 3)
  println(sortIntList(negative, values))

  val words3 = List("ada", "rust")
  println(sortList(negativeNumberofS, words3))
}
