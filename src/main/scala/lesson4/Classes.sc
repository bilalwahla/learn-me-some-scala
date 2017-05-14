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

import org.scalatest.Matchers._
class ClassWithValParameter(val name: String)
val aClass = new ClassWithValParameter("Gandalf")
aClass.name should be ("Gandalf")

object Greeting {
  def english = "Hi"

  def espanol = "Hola"
}

val x = Greeting
val y = x

x eq y should be(true) //Reminder: eq checks for reference

val z = Greeting

x eq z should be(true)

class Movie(val name: String, val year: Short)

object Movie {
  def academyAwardBestMoviesForYear(x: Short) = {
    //This is a match statement, more powerful than a Java switch statement!
    x match {
      case 1930 ⇒ Some(new Movie("All Quiet On the Western Front", 1930))
      case 1931 ⇒ Some(new Movie("Cimarron", 1931))
      case 1932 ⇒ Some(new Movie("Grand Hotel", 1932))
      case _ ⇒ None
    }
  }
}

Movie.academyAwardBestMoviesForYear(1932).get.name should be("Grand Hotel")
// Notice the way we are getting the object held by Option

// A companion object can also see private values and variables of the corresponding classes' instantiated objects
class Person(val name: String, private val superheroName: String) //The superhero name is private!

object Person {
  def showMeInnerSecret(x: Person) = x.superheroName
}

val clark = new Person("Clark Kent", "Superman")
val peter = new Person("Peter Parker", "Spiderman")

Person.showMeInnerSecret(clark) should be("Superman")
Person.showMeInnerSecret(peter) should be("Spiderman")