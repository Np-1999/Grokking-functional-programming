package chapter1TheFunctionalToolkit

object PracticingFunctionsInScala {

  def getFirstCharacter(S: String): Char = {
    S.charAt(0)
  }

  def increment(x: Int): Int = {
    x + 1
  }

  def wordScore(word: String): Int = {
    word.length
  }
}
