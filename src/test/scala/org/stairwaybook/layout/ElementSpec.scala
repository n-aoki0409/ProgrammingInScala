package org.stairwaybook.layout

import org.scalatest.{FlatSpec, Matchers}
import org.stairwaybook.layout.Element.elem

class ElementSpec extends FlatSpec with Matchers {
  "A UniformElement" should "hava a width equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.width should be (2)
  }
  it should "have a height equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.height should be (3)
  }
  it should "throw an IAE if passed a nagative width" in {
    an [IllegalArgumentException] should be thrownBy {
      elem('x', -2, 3)
    }
  }
}
