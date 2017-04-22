1.to(10).reduceLeft(_ * _)
// i.e. modern replacement
1.to(10).product

def factorial(n: Int): Int = 1.to(n).product
factorial(10)

def twoPowerN(n: Int): Int = 1.to(n).map(x => 2).product
twoPowerN(3)

def xPowerN(number: Int, power: Int) = 1.to(power).map(x => number).product
xPowerN(3, 3)

def concat(strings: Seq[String], separator: String) =
  strings.reduceLeft(_ + separator + _)

concat(Array("Marry", "had", "a", "little", "Lamb"), "|")