package chapter4Functions

import chapter4Functions.CoffeeBreakFuncAsParam.words

object CoffeeBreakFuncAsParam extends App {

  def Score(a: String): Int = {
    a.replace("a", "").length
  }

  def Bonus(a: String): Int = {
    if a.contains("c") then 5
    else 0
  }

  def Penalty(a: String): Int = {
    if a.contains("s") then 7
    else 0
  }

  val words = List("rust", "java")
  def rankedWords(wordScore: String => Int, words: List[String]): List[String] = {
    val sortedList = words.sortBy(wordScore).reverse // Collection function
    sortedList
  }
  println(rankedWords(w => Score(w) + Bonus(w) - Penalty(w), words))

  // Map
  def wordScores(score: String => Int, words: List[String]): List[Int] = {
    words.map(score)
  }
  println(wordScores(w => Score(w) + Bonus(w) - Penalty(w), words))

  // Filter
  def wordsWithHighscore(words: List[String], wordScore: String => Int): List[String] = {
    words.filter(word => wordScore(word) > 1)
  }

  println(wordsWithHighscore(words, w => Score(w) + Bonus(w) - Penalty(w)))

  def wordsWithVariableHighscore(words: List[String], wordScore: String => Int): Int => List[String] = { higherThan =>
    words.filter(word => wordScore(word) > higherThan)
  }

  // Upgraded version of wordsWithVaribaleHighscoer
  def highScoringWords(wordScore: String => Int)(higherThan: Int)(words: List[String]): List[String] = {
    words.filter(w => wordScore(w) > higherThan)
  }

  val variableHs = wordsWithVariableHighscore(words, w => Score(w) - Penalty(w) + Bonus(w))
  println(variableHs(-4))
  println(highScoringWords(w => Score(w) - Penalty(w) + Bonus(w))(-4)(words))

  // foldLeft
  def cumulativeScore(wordScore: String => Int, words: List[String]): Int = {
    words.foldLeft(0)((total, word) => total + wordScore(word))
  }
  println(cumulativeScore(w => Score(w) - Penalty(w) + Bonus(w), words))

}
