package org.stairwaybook.equality

class ColoredPoint(x: Int, y: Int, val color: Color.Value) extends Point(x, y) {
  override def equals(other: Any) = other match {
    case that: ColoredPoint =>
      (that canEqual this) &&
      (this.color == that.color) && super.equals(that)
    case _ => false
  }
  override def canEqual(other: Any) = other.isInstanceOf[ColoredPoint]
}
