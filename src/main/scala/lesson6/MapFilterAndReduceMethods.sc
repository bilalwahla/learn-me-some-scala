/*
 As seen before in the lesson map applies a given function to each
 element of the sequence.
  */
(1 to 9).map(0.1 * _)

/*
Filter retains the elements that fulfill a predicate.
 */
(1 to 9).filter(_ % 2 == 0)

/*
Unlike map and filter reduceLeft takes a function with 2
arguments.
 */
(1 to 9).reduceLeft((x: Int, y: Int) => x * y)
// OR a rather cooler and shorter form
(1 to 9).reduceLeft((x, y) => x * y)
// OR even cooler. Let Scala do the magic (infers the types).
(1 to 9).reduceLeft(_ * _)
// And that was not simple enough. More modern.
(1 to 9).product
