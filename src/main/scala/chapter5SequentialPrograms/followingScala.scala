package chapter5SequentialPrograms

object followingScala extends App {
  case class Book(title: String, authors: List[String])

  val books = List(
    Book("FP in Scala", List("Chiusano", "Bjarnason")),
    Book("The Hobbit", List("Tolkien")),
    Book("Modern Java in Action", List("Urma", "Fusco", "Mycroft"))
  )

  // Flatten: Flattens the list of lists into a list
  println(books.map(_.authors))
  println(books.map(_.authors).flatten)

  // flatMap: Combines map and flatten
  println(books.flatMap(_.authors))

  case class Movie(title: String)

  def bookAdaptations(author: String): List[Movie] = {
    if (author == "Tolkien") {
      List(Movie("An Unexpected Journey"), Movie("The Desolation of Smaug"))
    }
    else List.empty
  }
  println(
    books.flatMap(_.authors).flatMap(bookAdaptations)
  )

  val movies = books.flatMap(_.authors).flatMap(bookAdaptations)

  // Nested flatMap
  val recommendation = books.flatMap(book => {
    book.authors.flatMap(author => {
      bookAdaptations(author).map(movie => {
        s"You may like ${movie.title}, " +
          s"because you liked $author's ${book.title}"
      })
    })
  })

  println(recommendation)

  // for comprehensions: Better way to write flatMaps
  val recommendationbyForC = for {
    book <- books // Extract book from books
    author <- book.authors // Extract author from book.authors
    movie <- bookAdaptations(author) // Extract movie from List[Movie]
  } yield s"You may like ${movie.title}, " + // return String
    s"because you liked $author's ${book.title}"

  println(recommendationbyForC)
}
