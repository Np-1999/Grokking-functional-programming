package chapter5SequentialPrograms

object ScalaForComprehensionFilter extends App {
  case class Point(x: Int, y: Int)
  val points = List(Point(5, 2), Point(1, 1))
  val radiuses = List(2, 1)

  def isInside(point: Point, radius: Int): Boolean = {
    radius * radius >= point.x * point.x + point.y * point.y
  }

  val newList = for {
    r <- radiuses
    point <- points
  } yield s"$point is inside of radius $r: " + isInside(point, r).toString
  println(newList)

  // Filtering inside for

  // using filter
  val filteredList = for {
    r <- radiuses
    point <- points.filter(p => isInside(p, r))
  } yield s"$point exist in circle with radius $r"

  println(filteredList)

  // using a guard expression
  val guardFilteredList = for {
    r <- radiuses
    point <- points
    if isInside(point, r)
  } yield s"$point is within a radius of $r"
  println(guardFilteredList)

  // using a function passed to flatmap. This is universal technique which can be used beyond collection type
  def insideFilter(point: Point, r: Int): List[Point] = {
    if isInside(point, r) then List(point) else List.empty
  }

  val univerSalFilter = for {
    r <- radiuses
    point <- points
    inPoint <- insideFilter(point, r)
  } yield s"$point is within a radius of $r"
  println(univerSalFilter)

  // Coffee break

  // using filter
  val riskyRadiuses = List(-10, 0, 2)
  val coffeeBreak1 = for {
    r <- riskyRadiuses.filter(r => r > 0)
    point <- points.filter(p => isInside(p, r))
  } yield s"CF1op: $point is inside $r"
  println(coffeeBreak1)

  // using function passed to flatmap
  def insideFilterCF(point: Point, r: Int): List[Point] = {
    if r < 0 then List.empty
    else insideFilter(point, r)
  }

  val functionCf = for {
    r <- riskyRadiuses
    point <- points
    inPoint <- insideFilterCF(point, r)
  } yield s"$inPoint exist in radius $r"
  println(functionCf)

  // using guardCF

  val guardCF = for {
    r <- riskyRadiuses
    point <- points
    if r > 0 && isInside(point, r)
  } yield s"$point is inside $r"
  println(guardCF)
}
