package chapter3ImmutableValues

object CoffeeBreakStringApi extends App {
  def abbreviate(name: String): String = {
    val nameArray = name.split(" ")
    val intialChar = name.charAt(0)
    if (nameArray.length == 2) {
      intialChar + ". " + nameArray(1)
    }
    else {
      intialChar + "."
    }
  }

  println(abbreviate("Alonzo Church"))
  println(abbreviate("A. Church"))
  println(abbreviate("A Church"))

}
