import org.stairwaybook.equality._

object Main {
  var x = 1
  def main(args: Array[String]): Unit = {
    x = 1
    notdelayed(x * 2)
    x = 1
    delayed(x * 2)
  }

  def notdelayed(value: Int): Unit = {
    x = 100
    println("notdelayed: " + value)
  }
  def delayed(value: => Int): Unit = {
    x = 100
    println("delayed: " + value)
    x = 200
    println("delayed: " + value)
  }
}