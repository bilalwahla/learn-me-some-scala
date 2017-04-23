// Recursive data structures
abstract class Expr
case class Num(value: Int) extends Expr
case class Sum(left: Expr, right: Expr) extends Expr
case class Product(left:Expr, right: Expr) extends Expr

def eval(expr: Expr): Int = expr match {
  case Num(value) => value
  case Sum(left, right) => eval(left) + eval(right)
  case Product(left, right) => eval(left) * eval(right)
}
val expr = Product(Num(3), Sum(Num(2), Num(5)))
eval(expr)

// Polymorphism
abstract class Expr2 {
  def eval: Int
}

class Num2(val value: Int) extends Expr2 {
  def eval: Int = value
}

class Sum2(val left: Expr2, val right: Expr2) extends Expr2 {
  def eval: Int = left.eval + right.eval
}

class Product2(val left:Expr2, val right: Expr2) extends Expr2 {
  def eval: Int = left.eval * right.eval
}
val expr2 = new Product2(new Num2(3), new Sum2(new Num2(2), new Num2(5)))
expr2.eval

// Polymorphism is appropriate for an open-ended collection of classes.
/*
 Case classes and pattern matching are better for a bounded collection.
 Case classes give you concise code with all the cases in one place.
  */