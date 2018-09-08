package org.stairwaybook.parsing

import java.io.FileReader

object ParseJSON extends JSON1 {
  def main(args: Array[String]) = {
    val reader = new FileReader("/Users/n-aoki/IdeaProjects/Programming In Scala/src/main/scala/org/stairwaybook/parsing/address-book.json")
    println(parseAll(value, reader))
  }
}
