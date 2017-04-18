trait Logged {
  def log(msg: String): Unit = {}
}

trait ConsoleLogger extends Logged {
  override def log(msg: String): Unit = { println(msg) }
}

class SavingsAccount extends Logged {
  private var balance: Double = 0
  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }
}
val acct = new SavingsAccount with ConsoleLogger
acct.withdraw(10)

trait TimestampLogger extends Logged {
  override def log(msg: String): Unit = super.log(
    new java.util.Date() + " " + msg
  )
}

trait ShortLogger extends Logged {
  val maxLength = 15
  override def log(msg: String): Unit = {
    super.log(
      if (msg.length <= maxLength) msg
      else msg.substring(0, maxLength - 3) + "..."
    )
  }
}

val acct2 = new SavingsAccount with ConsoleLogger with TimestampLogger with ShortLogger {
  override val maxLength: Int = 20
}
acct2.withdraw(10)

val acct3 = new SavingsAccount with ConsoleLogger with ShortLogger with TimestampLogger {
  override val maxLength: Int = 45
}
acct3.withdraw(10)

val acct4 = new SavingsAccount with ShortLogger with TimestampLogger with ConsoleLogger
acct4.withdraw(10)