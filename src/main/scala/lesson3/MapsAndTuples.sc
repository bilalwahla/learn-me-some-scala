val scores = Map("Bilal" -> 5, "Waqas" -> 2, "Shabbir" -> 8) // immutable by default
val mutableScores = scala.collection.mutable.Map("Bilal" -> 5)
"Bilal" -> 5 // This expression gives us a key-value pair

// Access map values using () with key passed in
scores("Bilal")
//scores("Mohammad") // NoSuchElementException
scores.getOrElse("Mohammad", 0)

// Manipulate mutable map
mutableScores
mutableScores += "Waqas" -> 2
mutableScores += "Random" -> 20
mutableScores -= "Random"
mutableScores += "Waqas" -> 4

// play with immutable map
val scores2 = scores + ("Aoun" -> 7)
//scores("Aoun") // NoSuchElementException because original map was never changed
scores2("Aoun")
var scores3 = scores2 - "Aoun"
//scores3("Aoun") // NoSuchElementException as it is a result with the element removed
scores3 += "Aoun" -> 7 // But scores3 being a var, we can modify itself
scores3 += "Aoun" -> 8 // Update value for a key
scores3

// Iterating over maps
for ((k, v) <- scores) println(k + " scored " + v)
for ((k, v) <- scores) yield (v, k) // yield yields the contextual type
scores.keySet
scores.values

// Tuples
val tuple = (1, 3.14, "Bilal")
tuple._2
tuple._1 // unlike arrays tuple position starts at 1 and not 0

val (_, second, third) = tuple