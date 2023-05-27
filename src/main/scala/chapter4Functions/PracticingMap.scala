package chapter4Functions

object PracticingMap extends App {
  def scoreLen(word: String): Int = {
    word.length
  }

  def numberOfS(word: String): Int = {
    word.count(x => if x == 's' then true else false)
  }

  def negate(number: Int): Int = {
    -number
  }

  def double(number: Int) = {
    number * 2
  }

  val words = List("scala", "rust", "ada")
  println(words.map(scoreLen))

  val wordswitS = List("rust", "ada")
  println(wordswitS.map(numberOfS))

  val negateNumbers = List(5, 1, 2, 4, 0)
  println(negateNumbers.map(negate))

  val doubleNumbers = List(5, 1, 2, 4, 0)
  println(doubleNumbers.map(double))

}
