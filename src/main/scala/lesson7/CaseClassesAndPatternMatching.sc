// Extractors
// In pairs
val pair = "North Yorkshire".partition(_.isUpper)
pair match {
  case ("NY", _) => "North Yorkshire"
  case ("SY", _) => "South Yorkshire"
  case ("EY", _) => "East Yorkshire"
  case ("WY", _) => "West Yorkshire"
  case _ => "Not Yorkshire"
}

// In arrays
val arr = Array(1, 2, 3, 4)
arr match {
  case Array(1) => "[1]"
  case Array(x, y) => "[" + x + "," + y + "]"
  case Array(1, _*) => arr.product
  case _ => "Something else"
}

// In variable declaration
val (uppercase, lowercase) = "North Yorkshire".partition(_.isUpper)
val Array(first, second, _*) = arr // don't care about the rest
val Array(first2, second2, rest @ _*) = arr

// In loops
val scores = Map("Bilal" -> 5, "Waqas" -> 2, "Shabbir" -> 8)
for ((key, value) <- scores) println(key + " -> " + value)

def sum(xs: List[Int]): Int = xs match {
  case List() => 0
  case y :: ys => y + sum(ys)
}
val xs = List(1, 2, 3, 4)
sum(xs)