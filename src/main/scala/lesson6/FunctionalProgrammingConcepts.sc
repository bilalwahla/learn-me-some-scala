// Concepts of Functional Programming
/*
1 - A function is as good as anything and can be stored in a
variable.
 */
val triple = (x: Double) => 3 * x

/*
2 - You can give a function to any function/method. For that you
need to have a function that is willing to accept functions e.g.
map.
 */
Array(3.14, 1.42, 2.0).map(triple)

/*
3 - Anonymous functions.
 */
Array(2.1, 3.2, 4.3).map((x: Double) => x * 4)

/*
4 - You can define all functions as def or val but for recursive
functions you do need def.
5 - You can often just use anonymous functions. You should name
them only if they are to be used many times or for the purpose of
documentation.
 */

// nth fib
def fib(n: Int): Int = {
  def loop(n: Int, prev: Int, cur: Int): Int =
    if (n <= 0) prev else loop(n - 1, cur, prev + cur)
  loop(n, 0, 1)
}

fib(13)