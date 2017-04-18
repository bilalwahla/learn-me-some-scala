import java.net.URL
import java.util.Scanner

val in = new Scanner(
  new URL(
    "http://horstmann.com/presentations/livelessons-scala-2016/alice30.txt"
  ).openStream
)

// Mutable map
//val count = scala.collection.mutable.Map[String, Int]()
//while (in.hasNext) {
//  val word = in.next
//    count(word) = count.getOrElse(word, 0) + 1
//}
//count("Alice")
//count("Rabbit")

// Immutable Map
var count2 = Map[String, Int]()
while (in.hasNext) {
  val word = in.next
    count2 += word -> (count2.getOrElse(word, 0) + 1)
}
count2("Alice")
count2("Rabbit")