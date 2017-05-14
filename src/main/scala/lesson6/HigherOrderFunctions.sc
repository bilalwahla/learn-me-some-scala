import scala.math._
/*
A function that consumes and/or produce a function is a higher
order function.

Example of a function that consumes a function.
 */
def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
valueAtOneQuarter(sqrt)
valueAtOneQuarter(ceil)

/*
Example of a function that produces a function
 */
def mulBy(factor: Double) = (x: Double) => factor * x
val quadruple = mulBy(4)
/*
 So quadruple is a function that takes a Double and results in
  a Double that is four times the passed in value
  */
quadruple(25)
valueAtOneQuarter(quadruple)

/*
 Take apart quadruple. Result should be a Double value
 that is 1/4th of 4
  */
valueAtOneQuarter((x: Double) => 4 * x)

/*
 Take apart mulBy(100) below. Guess the result. That's right, 25.
  */
valueAtOneQuarter((x: Double) => 100 * x)
/*
 So its like 0.25 is being passed in to the mulBy(100) function.
  */

// Parameter inference
/*
 Scala knows that valueAtOneQuarter takes a function that takes a
 Double, we can omit the need to tell it.
  */
valueAtOneQuarter((x) => 100 * x)

// Can even omit the () if there is only one parameter
valueAtOneQuarter(x => 100 * x)

/*
 If the parameter variable occurs only once in the body, we do
 not even need to specify the parameter and =>. And in the body
 replace it with _
  */
valueAtOneQuarter(100 * _) // Could it be tidier

import org.scalatest.Matchers._

def lambda = { x: Int => x + 1 }

def lambda2 = (x: Int) => x + 2

val lambda3 = (x: Int) => x + 3

val lambda4 = new ((Int) => Int) {
  def apply(v1: Int): Int = v1 - 1
}

def lambda5(x: Int) = x + 1

val result = lambda(3)
val `result1AndHalf` = lambda.apply(3)

val result2 = lambda2(3)
val result3 = lambda3(3)
val result4 = lambda4(3)
val result5 = lambda5(3)

result should be(4)
result1AndHalf should be(4)
result2 should be(5)
result3 should be(6)
result4 should be(2)
result5 should be(4)

/**
  * A closure is a function which maintains a reference to one or more variables outside of the function scope (it
  * "closes over" the variables). Scala will detect that you are using variables outside of scope and create an object
  * instance to hold the shared variables.
  */
var incrementer = 1
def closure = (x: Int) => x + incrementer

val result6 = closure(10)
result6 should be(11)

incrementer = 2
val result7 = closure(10)
result7 should be(12)

// We can take that closure and throw it into a method and it will still hold the environment
def summation(x: Int, y: Int => Int) = y(x)

incrementer = 3
def closure2 = (x: Int) => x + incrementer

val result8 = summation(10, closure2)
result8 should be(13)

incrementer = 4
val result9 = summation(10, closure2)
result9 should be(14)

// Function returning another function
def f(x: Int) = (y: Int) => x + y
f(1).isInstanceOf[(Int) => Int]
f(2)(3) should be(5)

def fiveAdder = f(5)
fiveAdder.isInstanceOf[(Int) => Int]
fiveAdder(5) should be(10)

// Function taking another function
def makeUpper(xs: List[String]) = xs map {
  _.toUpperCase
}

def makeWhatEverYouLike(xs: List[String], sideEffect: String => String) = xs map sideEffect

makeUpper(List("abc", "xyz", "123")) should be(List("ABC", "XYZ", "123"))

makeWhatEverYouLike(List("ABC", "XYZ", "123"), x => x.toLowerCase) should be(List("abc", "xyz", "123"))

//using it inline
List("Scala", "Erlang", "Clojure") map (_.length) should be(List(5, 6, 7))
