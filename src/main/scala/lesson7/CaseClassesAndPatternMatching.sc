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

case class Cart(fruits: List[String], appleCost: Double, orangeCost: Double)
object Cart {
  val orange = "Orange"
  val apple = "Apple"

  def checkout(cart: Cart): Double = cart.fruits match {
    case Nil => 0.00
    case f :: fs if f == apple =>
      cart.appleCost + checkout(new Cart(fs, cart.appleCost, cart.orangeCost))
    case f :: fs if f == orange =>
      cart.orangeCost + checkout(new Cart(fs, cart.appleCost, cart.orangeCost))
    case f :: _ => throw new IllegalArgumentException(s"Fruit $f not available")
  }

  def checkoutWithOffers(cart: Cart): Double = {
    val appleCount = cart.fruits.count(_ == apple)
    val buyOneGetOneFree = appleCount / 2 + appleCount % 2
    val orangeCount = cart.fruits.count(_ == orange)
    val threeForTwo = (orangeCount / 3) * 2 + orangeCount % 3
    checkout(
      new Cart(
        List.fill(buyOneGetOneFree)(apple) ++ List.fill(threeForTwo)(orange),
        cart.appleCost,
        cart.orangeCost
      )
    )
  }
}
val cart = Cart(List("Apple", "Apple", "Orange", "Apple", "Orange", "Orange"), 0.60, 0.25)
Cart.checkout(cart)
Cart.checkoutWithOffers(cart)

def checkout(fruits: List[String]): Double = fruits match {
  case Nil => 0.00
  case f :: fs if f == "Apple" => 0.60 + checkout(fs)
  case f :: fs if f == "Orange" => 0.25 + checkout(fs)
}
checkout(List("Apple", "Orange", "Orange"))