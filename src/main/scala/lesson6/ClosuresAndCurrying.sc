// Closures
/*
- A function has access to any variable from any enclosing scope
- even when the variable is no longer around when you call the
function.
 */
def mulBy(factor: Double) = (x: Double) => factor * x
val triple = mulBy(3)
triple(14)
/*
In above code:
1 - when calling mulBy(3), factor is set to 3.
2 - when mulBy(3) returns, triple is set to the returned function.
3 - and the parameter variable factor is no more.
4 - when triple(14) is called, factor * 14 is computed.

For this to work triple retains 3. So function is not just code,
it is code with values for free variables (the ones not locally
defines) in this case factor. This is called closure. Closure
being an object with an instance variable for the captured
variable, and the method that contains the code.
 */

/*
 Currying: turning a function that takes two arguments into a
 function that takes one argument, in a way that this curried
 function returns a function that takes the second argument.
  */
def mul(x: Int, y: Int) = x * y
// the curried version
def mulOneAtATime(x: Int) = (y: Int) => x * y
val triple2 = mulOneAtATime(3)
triple2(14)
// OR directly pass the parameter to the returned function
mulOneAtATime(3)(14)
// OR currying with some Scala syntactic sugar
def mulOneAtATime2(x: Int)(y: Int) = x * y
mulOneAtATime2(3)(100)