package org.stairwaybook.layout

import org.specs2.mutable._
import org.stairwaybook.layout.Element.elem

object ElementSpecification extends Specification {
  "A uniformElement" should {
    "have a width equal to the passed value" >> {
      val ele = elem('x', 2, 3)
      ele.width must be_==(2)
    }
  }
  "have a height equal to the passed value" >> {
    val ele = elem('x', 2, 3)
    ele.height must be_==(3)
  }
  "throw an IAE if passed a negative width" >> {
    elem('x', -2, 3) must throwA[IllegalArgumentException]
  }
}
