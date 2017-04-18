import scala.collection.mutable.ArrayBuffer

def findNegativeNoIndices(arrayBuffer: ArrayBuffer[Int]) =
  for (i <- arrayBuffer.indices if arrayBuffer(i) < 0) yield i

def removeAllButFirstNegativeNo(arrayBuffer: ArrayBuffer[Int]) = {
  val negativeNoIndicesToRemove = findNegativeNoIndices(arrayBuffer).drop(1).reverse
  for (i <- arrayBuffer.indices if !negativeNoIndicesToRemove.contains(i))
    yield arrayBuffer(i)
}

val arrayBuffer = ArrayBuffer(1, 2, -1, 3, 4, -5, 5, 6, -7)
removeAllButFirstNegativeNo(arrayBuffer)
arrayBuffer