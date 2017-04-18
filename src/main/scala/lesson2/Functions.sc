def abs(x: Double) = if (x > 0) x else -x

/**
  * If return type can not be inferred, it must be specified e.g. a recursive function.
  * @param n an integer to calculate the factorial for
  * @return factorial
  */
def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)

// Procedure rather than a function that does not return a value
def box(s: String): Unit = {
  val border = "*" * s.length + "**\n"
  println(border + "|" + s + "|\n" + border)
}

box("Hello Scala World!")

// Named and default function arguments
def decorate(str: String, left: String = "[", right: String = "]") = left + str + right
decorate("Hello Scala World!")
decorate("Hello Scala World!", "***[", "]***")
decorate(left = "---", right = "---", str = "Hello")

// Variable function arguments
def sum(numbers: Int*) = {
  var result = 0
  for (n <- numbers) result += n
  result
}
sum(1, 2, 3, 4)
sum(1 to 10 : _*) // a range of 1 to 10 as a sequence

def recursiveSum(numbers: Int*): Int = {
  if (numbers.isEmpty) 0
  else numbers.head + recursiveSum(numbers.tail : _*)
}
recursiveSum(1, 2, 3, 4)
