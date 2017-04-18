class Point (val x: Double, val y: Double) {
  println(s"Welcome to point ($x, $y)")

  def move(dx: Double, dy: Double) = new Point(x + dx, y + dy)
  def distanceFromOrigin = math.sqrt(x * x + y * y)

  override def toString: String = f"($x, $y)"
}
val point = new Point(3, 4)
point.move(10, 20)
point.distanceFromOrigin
point.x
point.y

// Companion objects can access each other's private features
object Point {
  def apply(x: Double, y: Double): Point = new Point(x, y)
}
/*
Notice we do not need to use the keyword 'new'. We also do not need to call
apply method because if not specified apply method is applied. So the
example below is equivalent of val point2 = Point.apply(3, 4). apply being a
static method in the companion object.
 */
val point2 = Point(3, 4)

object Accounts {
  private var lastNumber = 0
  def newUniqueNumber() = {
    lastNumber += 1
    lastNumber
  }
}
Accounts
Accounts.newUniqueNumber()
Accounts.newUniqueNumber()