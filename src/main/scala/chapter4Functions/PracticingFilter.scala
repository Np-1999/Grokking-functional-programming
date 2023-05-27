package chapter4Functions

object PracticingFilter extends App {
  val words = List("scala", "rust", "ada")
  println(words.filter(w => w.length < 5))

  val words2 = List("rust", "ada")
  println(words2.filter(w => w.count(x => if x == 's' then true else false) > 2))

  val numbers = List(5, 1, 2, 4, 0)
  println(numbers.filter(n => n % 2 == 1))

  val numbers2 = List(5, 1, 2, 4, 0)
  println(numbers2.filter(n => n > 4))


}
