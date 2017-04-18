val a = new Array[Int](10)
for (i <- a.indices) a(i) = i * i
a

// ArrayBuffer for Java's ArrayList
import scala.collection.mutable.ArrayBuffer
val b = ArrayBuffer("Marry", "had", "a", "little", "lamb")
b += "its"
b += ("fleece", "was", "white")
b ++= Array("as", "snow")
b.remove(3)
b
b.insert(3, "massive")
b
b.trimEnd(5)

// conversion between arrays and array buffers
val c = b.toArray
val b2 = c.toBuffer

// Transform arrays
val d = Array(12, 2, 3, 21, 5, 6, 7, 11)
val transformedD = for (element <- d if element % 2 != 0) yield element * 2

// Common algorithms
d.sum
b.max
d.sorted // you get back a sorted result
d // original remains the same
d.reverse // again you get the result of reversed array
d // and the original remains the same
d.toString // toString on Array works just like Java
d.mkString("|")
d.mkString("[", ",", "]")
b.toString() // toString on Scala's ArrayBuffer does not work like Java
b.mkString("[", ",", "]")