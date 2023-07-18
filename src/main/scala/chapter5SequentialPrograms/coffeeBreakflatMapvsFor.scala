package chapter5SequentialPrograms

object coffeeBreakflatMapvsFor extends App {
  case class Point(x: Int, y: Int)
  val xs = List(1)
  val ys = List(-2, 7)
  val zs = List(3, 4)

  val points = for {
    x <- xs
    y <- ys
  } yield Point(x, y)

  println(points)

  case class Point3D(x: Int, y: Int, z: Int)
  val Points3d = for {
    x <- xs
    y <- ys
    z <- zs
  } yield Point3D(x, y, z)
  println(Points3d)

  println(
    xs.flatMap(x => ys.flatMap(y => zs.map(z => Point3D(x, y, z))))
  )

}
