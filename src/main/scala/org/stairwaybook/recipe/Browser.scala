package org.stairwaybook.recipe

abstract class Browser {
  val database: Database
  def recipesUsing(food: String): List[Recipe] =
    database.foodNamed(food) match {
      case Some(food) => database.allRecipes.filter(recipe => recipe.ingredients.contains(food))
      case _ => Nil
    }

  def displayCategory(category: database.FoodCategory) = {
    println(category)
  }
}
