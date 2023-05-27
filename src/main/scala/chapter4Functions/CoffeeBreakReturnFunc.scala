package chapter4Functions

object CoffeeBreakReturnFunc extends App {
  def variableHigherthan(numbers: List[Int]): Int => List[Int] = { higherThan =>
    numbers.filter(num => num > higherThan)
  }

  def divisibleBy(numbers: List[Int]): Int => List[Int] = { divisible =>
    numbers.filter(num => num % divisible == 0)
  }

  def shorterThan(words: List[String]): Int => List[String] = { short =>
    words.filter(word => word.length < short)
  }

  def wordsWithS(words: List[String]): Int => List[String] = { moreThan =>
    words.filter(w => w.count(x => if x == 's' then true else false) > moreThan)
  }

  val numbers = List(5, 1, 2, 4, 0)
  val higherT = variableHigherthan(numbers)
  println(higherT(4))
  println(higherT(1))

  val numbers2 = List(5, 1, 2, 4, 15)
  val zeroModBy = divisibleBy(numbers2)
  println(zeroModBy(5))
  println(zeroModBy(2))

  val words = List("scala", "ada")
  val shorterT = shorterThan(words)
  println(shorterT(4))
  println(shorterT(7))

  val words2 = List("rust", "ada")
  val numberofS = wordsWithS(words2)
  println(numberofS(2))
  println(numberofS(0))

}
