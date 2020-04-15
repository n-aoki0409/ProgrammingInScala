import java.io.FileReader

import org.stairwaybook.parsing.JSON

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

object Main extends App with JSON {
  val reader = new FileReader(
    "/Users/n-aoki/work/programming-in-scala/src/main/scala/org/stairwaybook/parsing/address-book.json")
  println(parseAll(value, reader))
}
