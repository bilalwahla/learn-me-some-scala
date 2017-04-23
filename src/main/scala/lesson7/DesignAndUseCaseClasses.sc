/*
 Cases class is class that is optimised for use in pattern
 matching.

 1 - all of the construction parameters become val
 2 - companion object gets an apply factory method e.g. you can just
 do val dollar = Dollar(100) i.e. without a new
 3 - methods toString, equals, hashCode, unapply and copy are
 generated
  */
abstract class Amount
case class Dollar(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object Nothing extends Amount

def simplifyMoney(curr: Amount) = curr match {
  case Dollar(value) => "$" + value
  case Currency(value, unit) => unit + "" + value
  case Nothing => "Currency not supported!"
}
val amt = Currency(50.00, "GBP")
simplifyMoney(amt)
val amt2 = Dollar(100.00)
simplifyMoney(amt2)
val amt3 = Nothing
simplifyMoney(amt3)
simplifyMoney(amt.copy(value = 60.00))
