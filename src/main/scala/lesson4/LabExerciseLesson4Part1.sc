class Time(val hours: Int = 0, val minutes: Int = 0) {
  if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59)
    throw new IllegalArgumentException

  override def toString: String = f"$hours%02d:$minutes%02d"

  def isBefore(other: Time): Boolean = {
    if (hours < other.hours) true
    else if (hours == other.hours && minutes < other.minutes) true
    else false
  }
}
val time = new Time(6, 30)
val timeAfterInHours = new Time(7, 30)
val timeAfterInMinutes = new Time(6, 31)
val timeBeforeInHours = new Time(5, 30)
val timeBeforeInHours2 = new Time(4)
val timeBeforeInMinutes = new Time(6, 29)
time.isBefore(timeAfterInHours) // true
time.isBefore(timeAfterInMinutes) // true
time.isBefore(timeBeforeInHours) // false
time.isBefore(timeBeforeInMinutes) // false
time.isBefore(timeBeforeInHours2) // false
//val badTime = new Time(26, 66)