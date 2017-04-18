val x = 2
val result = if (x > 0) "Greater" else -1

val x2 = -1
val result2 = if (x2 > 0) "Greater"
val result3 = () // a 'void' is denoted by type Unit

// Looping
val n = 5
for (i <- 1 to n) println(i)
for (c <- "Hello Scala World!") println(c)
// Multiple "generators"
for (i <- 1 to n; j <- 1 to 3) print((10 * i + j) + " ")
// Guards
for (i <- 1 to n; j <- 1 to 3 if i != j) print((10 * i + j) + " ")
// Collecting results
for (i <- 1 to n) yield i % 3