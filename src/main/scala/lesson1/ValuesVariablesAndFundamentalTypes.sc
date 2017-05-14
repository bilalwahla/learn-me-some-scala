println("Hello Scala World!")

8 + 5 * 2

// Immutable variable
val answer = 8 * 5 + 2
answer
// answer = 55

var response = 42
response = 44
response
// response = "Hello Scala World!"

var greeting: String = null
greeting = "Hello Scala World!"
greeting

1.to(10)
// Infix notation
1 to 10
1.+(10)

"Hello".intersect("Scala World!")
"civic".intersect("civic")

val x: BigInt = 123456789
x * x * x * x

import org.scalatest.Matchers._

val c = '\u0061' //unicode for a
val d = '\141' //octal for a
val e = '\"'
val f = '\\'

"%c".format(c) should be("a")
"%c".format(d) should be("a")
"%c".format(e) should be("\"")
"%c".format(f) should be("\\")

val j = 190
"%d bottles of beer on the wall" format j - 100 should be ("90 bottles of beer on the wall")