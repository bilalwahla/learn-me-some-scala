def runInThread(block: => Unit) {
  new Thread {
    override def run() { block }
  }.start()
}

runInThread {
  println("Hello Scala World!")
}