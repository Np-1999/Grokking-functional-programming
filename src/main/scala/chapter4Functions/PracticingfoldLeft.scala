package chapter4Functions

object PracticingfoldLeft extends App {
  val numbers = List(5, 1, 2, 4, 100)
  println(numbers.foldLeft(0)((sum, i) => sum + i))

  def wordLen(word: String): Int = {
    word.length
  }
  val words = List("scala", "rust", "ada")
  println(words.foldLeft(0)((sum, i) => sum + wordLen(i)))

  def numberOfS(str: String): Int = {
    str.count(x => if x == 's' then true else false)
  }
  println(List("scala", "haskell", "rust", "ada").foldLeft(0)((sum, i) => sum + numberOfS(i)))

  println(List(5, 1, 2, 4, 15).foldLeft(Integer.MIN_VALUE)((max, i) => if i > max then i else max))
}
