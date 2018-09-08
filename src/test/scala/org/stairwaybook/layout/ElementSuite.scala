package org.stairwaybook.layout

import org.scalatest.{DiagrammedAssertions, FunSuite}
import org.stairwaybook.layout.Element.elem

class ElementSuite extends FunSuite with DiagrammedAssertions {
  test("elem result should hava passed width") {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }

  test("elem result should have passed width by using assertResult") {
    val ele = elem('x', 2, 3)
    assertResult(2) {
      ele.width
    }
  }

  test("one divided zero throws ArithmeticException") {
    val caught = intercept[ArithmeticException] {
      1 / 0
    }
    assert(caught.getMessage == "/ by zero")
  }
}
