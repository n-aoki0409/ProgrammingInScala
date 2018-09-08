package org.stairwaybook.recipe

abstract class Food(val name: String) {
  override def toString = name
}

object Apple extends Food("Apple")
object Pear extends Food("Pear")
object Orange extends Food("Orange")
object Cream extends Food("Cream")
object Sugar extends Food("Sugar")
object FrozenFood extends Food("FrozenFood")