// Articles and bundles
abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item

val book = Article("Scala for the impatient", 39.95)
val offer = Bundle("Buy 2 books and save $10", 10.00, book, book)

def price(item: Item): Double = item match {
  case Article(_, p) => p
  case Bundle(_, disc, items @ _*) => items.map(it => price(it)).sum - disc
}
price(book)
price(offer)

val special = Bundle("Father's day special", 20.0, book,
  Bundle("Another special offer", 10.0,
    Article("Spring in Action", 44.49),
    Article("Kafka in Action", 29.99)
  )
)
val Bundle(_, _, Article(description, price), _*) = special