package org.stairwaybook.parsing

object ParseExpr extends Arith {
  def main(args: Array[String]) = {
    val input = "2 * (3 + 7)"
    println("input : " + input)
    println(parseAll(expr, input))
  }
}

