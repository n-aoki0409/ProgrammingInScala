package org.stairwaybook.recipe

trait SimpleFoods {
  this: FoodCategories =>
  def allFoods: List[Food] = List(Apple, Orange, Cream, Sugar)
  def allCategories: List[FoodCategory] = List(
    FoodCategory("fruits", List(Apple, Orange)),
    FoodCategory("misc", List(Cream, Sugar))
  )
}
