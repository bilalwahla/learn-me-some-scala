// Option type
abstract class OptionDouble
case class OptionDoubleSome(value: Double) extends OptionDouble
case object OptionDoubleNone extends OptionDouble

def inverse(x: Double) = if (x == 0) OptionDoubleNone else OptionDoubleSome(1 / x)
inverse(2)
inverse(0)

import scala.math._
def f(x: Double) = if (x <= 1) OptionDoubleSome(sqrt(1 - x)) else OptionDoubleNone

def compose(f: Double => OptionDouble, g: Double => OptionDouble) = (x: Double) => g(x) match {
  case OptionDoubleSome(result) => f(result)
  case OptionDoubleNone => OptionDoubleNone
}

val h = compose(f, inverse)
h(0)
h(1)
h(2)

def isEmpty(x: OptionDouble) = x match {
  case OptionDoubleNone => true
  case _ => false
}

def get(x: OptionDouble) = x match {
  case OptionDoubleSome(value) => value
  case OptionDoubleNone => throw new NoSuchElementException
}
