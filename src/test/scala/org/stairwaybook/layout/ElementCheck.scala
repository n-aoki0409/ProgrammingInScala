package org.stairwaybook.layout

import org.scalacheck.Gen
import org.scalatest.WordSpec
import org.scalatest.prop.PropertyChecks
import org.scalatest.MustMatchers._
import org.stairwaybook.layout.Element.elem

class ElementCheck extends WordSpec with PropertyChecks {
  "elem result" must {
    "have passed width" in {
      val ints = for (n <- Gen.choose(-1000, 1000)) yield n
      forAll (ints) { (w: Int) =>
        whenever (w > 0) {
          elem('x', w, 3).width must equal (w)
        }
      }
    }
  }
}
