def While(condition: () => Boolean, block: () => Unit): Unit = {
  if (condition()) {
    block()
    While(condition, block)
  }
}

val n = 5
var i = 1
var f = 1
While(() => i < n, () => {
  f *= i; i += 1
})
f

def While2(condition: => Boolean, block: => Unit): Unit = {
  if (condition) {
    block
    While2(condition, block)
  }
}

i = 1
var f2 = 1
While2(i < n, {
  f2 *= i; i += 1
})
f2

def myWhile(condition: => Boolean)(block: => Unit): Unit = {
  if (condition) {
    block
    myWhile(condition) {
      block
    }
  }
}

i = 1
var f3 = 1
myWhile(i < n) {
  f3 *= i; i += 1
}
f3

/*
 We have written our own while using the concepts of control
 abstraction and currying
  */