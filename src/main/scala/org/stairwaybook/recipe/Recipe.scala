package org.stairwaybook.recipe

class Recipe (
  val name: String,
  val ingredients: List[Food],
  val instructions: String) {

  override def toString = name
}

object FruitSalad extends Recipe(
  "fruit salad",
  List(Apple, Orange, Cream, Sugar),
  "Stir it all together.")
object HeatInUp extends Recipe(
  "heat it up",
  List(FrozenFood),
  "Microwave the 'food' for 10 minutes.")
