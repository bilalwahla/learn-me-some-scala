val scores = Map("Bilal" -> 5, "Waqas" -> 2, "Shabbir" -> 8)
scores.get("Someone") match {
  case Some(score) => println(score)
  case None => println("No score")
}

import org.scalatest.Matchers._
val someValue: Option[String] = Some("I am wrapped in something")
someValue should be(Some("I am wrapped in something"))

someValue match {
  case Some(str) => str
  case None => "missing data"
}

val emptyValue: Option[String] = None
emptyValue should be(None)

emptyValue match {
  case Some(str) => str
  case None => "missing data"
}

def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
  if (flag) Some("Found value") else None
}
val value1 = maybeItWillReturnSomething(true)
val value2 = maybeItWillReturnSomething(false)
value1 getOrElse "No value" should be("Found value")
value2 getOrElse "No value" should be("No value")
value2 getOrElse {
  "default function"
} should be("default function")
value1.isEmpty should be(false)
value2.isEmpty should be(true)

val number: Option[Int] = Some(3)
val noNumber: Option[Int] = None
val result1 = number.map(_ * 1.5)
val result2 = noNumber.map(_ * 1.5)

result1 should be(Some(4.5))
result2 should be(None)

/** Another operation is fold. This operation will extract the value from the option, or provide a default if the value
  * is None */
val number2: Option[Int] = Some(3)
val noNumber2: Option[Int] = None
val result3 = number.fold(0)(_ * 3)
val result4 = noNumber.fold(0)(_ * 3)

result3 should be(9)
result4 should be(0)