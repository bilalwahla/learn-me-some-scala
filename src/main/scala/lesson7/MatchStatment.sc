import scala.annotation.switch

val ch = '+'
val sign = ch match {
  case '+' => 1
  case '-' => -1
  case _ => 0
}

class SwitchDemo {
  val i = 2
  val two = 2
  val x: String = (i: @switch) match {
    case 1 => "One"
    case `two` => "Two"
    case _ => "Other"
  }
}
val switchDemo = new SwitchDemo
switchDemo.x

