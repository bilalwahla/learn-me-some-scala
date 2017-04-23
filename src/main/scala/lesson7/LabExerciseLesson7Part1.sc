// Pattern matching
def swap(pair: (Int, Int)) = pair match {
  case (x, y) => (y, x)
}
swap((2, 4))

def swap2(arr: Array[Int]) = arr match {
  case Array(x, y, rest @ _*) => Array(y, x) ++ rest
  case Array(x) => Array(x)
}
swap2(Array(1, 2, 3, 4))
