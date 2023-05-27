package chapter4Functions

object caseClasses extends App {
  case class ProgrammingLanguage(name: String, year: Int)

  val javalang = ProgrammingLanguage("Java", 1995)
  val scalalang = ProgrammingLanguage("Scala", 2004)
  val Languages = List(javalang, scalalang)
  println(Languages.map(lang => lang.name))
  println(Languages.map(_.name))

}
