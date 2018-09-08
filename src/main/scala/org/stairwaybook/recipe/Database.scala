package org.stairwaybook.recipe

abstract class Database extends FoodCategories {
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name: String): Option[Food] =
    allFoods.find(f => f.name == name)
}

object SimpleDatabase extends Database with SimpleFoods with SimpleRecipes

object StudentDatabase extends Database {
  def allFoods: List[Food] = List(FrozenFood)
  def allRecipes: List[Recipe] = List(HeatInUp)
  def allCategories: List[FoodCategory] = List(
    FoodCategory("edible", List(FrozenFood))
  )
}
