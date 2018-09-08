package org.stairwaybook.recipe

object GotApples {
  def main(args: Array[String]) = {
    val db: Database =
      if(args.length > 0)
        args(0) match {
          case "student" => StudentDatabase
          case _ => SimpleDatabase
        }
      else
        SimpleDatabase
    object browser extends Browser {
      val database: db.type = db
    }
    for (recipe <- browser.recipesUsing("Apple"))
      println(recipe)

    for (category <- db.allCategories)
      browser.displayCategory(category)
  }
}
