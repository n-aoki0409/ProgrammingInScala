package org.stairwaybook.parsing

import scala.util.parsing.combinator._

trait JSON1 extends JavaTokenParsers {
  def obj: Parser[Map[String, Any]] =
    "{" ~> repsep(member, ",") <~ "}" ^^ (Map() ++ _)
  def arr: Parser[List[Any]] = "[" ~> repsep(value, ",") <~ "]"
  def member: Parser[(String, Any)] = stringLiteral ~ ":" ~ value ^^ {
    case key ~ ":" ~ value => (key, value)
  }
  def value: Parser[Any] = (
    obj
      | arr
      | stringLiteral
      | floatingPointNumber ^^ (_.toDouble)
      | "null" ^^ (_ => null)
      | "true" ^^ (_ => true)
      | "false" ^^ (_ => false)
  )
}
