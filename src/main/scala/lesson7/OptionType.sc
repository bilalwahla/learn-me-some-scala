val scores = Map("Bilal" -> 5, "Waqas" -> 2, "Shabbir" -> 8)
scores.get("Someone") match {
  case Some(score) => println(score)
  case None => println("No score")
}