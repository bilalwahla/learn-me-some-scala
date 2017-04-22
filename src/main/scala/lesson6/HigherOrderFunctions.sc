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