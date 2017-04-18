import java.io.{FileInputStream, InputStream}

trait Logged {
  def log(msg: String): Unit = {}
}

trait ConsoleLogger extends Logged {
  override def log(msg: String): Unit = { println(msg) }
}

trait Buffered extends InputStream with Logged {
  val SIZE = 1024
  private var end = 0
  private val buffer = new Array[Byte](SIZE)
  private var pos = 0

  override def read() = {
    if (pos == end) {
      log("Buffer was empty")
      end = super.read(buffer, 0, SIZE)
      pos = 0
    }
    if (pos == end) -1 else {
      pos += 1
      buffer(pos - 1)
    }
  }
}

val fis = new FileInputStream("/usr/share/dict/words") with Buffered with ConsoleLogger
fis.read()
fis.read()
fis.read()