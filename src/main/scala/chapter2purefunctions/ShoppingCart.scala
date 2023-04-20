package chapter2purefunctions

object ShoppingCart extends App {

  def getDiscountPercentage(cart: List[String]): Int = {
    if (cart.contains("Book")) {
      5
    }
    else {
      0
    }
  }
  val justApple = List("Apple")
  println(getDiscountPercentage(justApple))
  val appleAndBook = List("Apple", "Book")
  println(getDiscountPercentage(appleAndBook))

}
