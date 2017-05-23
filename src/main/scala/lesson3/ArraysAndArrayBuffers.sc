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

import org.scalatest.Matchers._

// Lists can be reduced with a mathematical operation
val a1 = List(1, 3, 5, 7)
a1.reduceLeft(_ + _) // sum
a1.reduceLeft(_ * _) // product

// foldLeft is like reduce, but with an explicit starting value
val a3 = List(1, 3, 5, 7)
// NOTE: foldLeft uses a form called currying that we will explore later
a3.foldLeft(0)(_ + _) should equal(16)
a3.foldLeft(10)(_ + _) should equal(26)
a3.foldLeft(1)(_ * _) should equal(105)
a3.foldLeft(0)(_ * _) should equal(0)

// Lists reuse their tails
val d4 = Nil
val c4 = 3 :: d4
val b4 = 2 :: c4
val a4 = 1 :: b4

a4 should be(List(1, 2, 3))
a4.tail should be(List(2, 3))
b4.tail should be(List(3))
c4.tail should be(List())

def sum(xs: List[Int]): Int =
  if (xs.isEmpty) throw new IllegalArgumentException("sum of empty list")
  else if (xs.tail.isEmpty) xs.head
  else xs.head + sum(xs.tail)

val xs = List(1, 2, 3, 4)
sum(xs)

def max(xs: List[Int]): Int =
  if (xs.isEmpty) throw new NoSuchElementException("max of empty list")
  else if (xs.tail.isEmpty) xs.head
  else if (xs.head > xs.tail.head) max(xs.head :: xs.tail.tail)
  else max(xs.tail)
max(xs)

List(1, 2, 3, 4).max