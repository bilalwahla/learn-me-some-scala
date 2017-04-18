import scala.collection.mutable.ArrayBuffer

"Rahim Yar Khan".partition(_.isUpper)

val arrayBuffer = ArrayBuffer(1, 2, -1, 3, 4, -5, 5, 6, -7)
arrayBuffer.partition(_ < 0)

val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)
for ((s, n) <- pairs) print(s * n)
println()