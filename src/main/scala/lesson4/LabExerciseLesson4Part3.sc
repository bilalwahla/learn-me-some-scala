class Time(h: Int = 0, m: Int = 0) {
  private var minutesSinceMidnight = h * 60 + m
  def hours = minutesSinceMidnight / 60
  def minutes = minutesSinceMidnight % 60
  def minutes_= (newValue: Int) {
    if (newValue < 0 || newValue > 59)
      throw new IllegalArgumentException
    minutesSinceMidnight = hours * 60 + newValue
  }

  if (h < 0 || h > 23 || m < 0 || m > 59)
    throw new IllegalArgumentException

  def isBefore(other: Time): Boolean = this - other < 0

  def <(other: Time): Boolean = isBefore(other)

  def -(other: Time): Int = minutesSinceMidnight - other.minutesSinceMidnight

  override def toString: String = f"$hours%02d:$minutes%02d"
}

object Time {
  def apply(h: Int = 0, m: Int = 0): Time = new Time(h, m)
}

val time = new Time(6, 30)
val timeAfterInHours = new Time(7, 30)
val timeAfterInMinutes = new Time(6, 31)
val timeBeforeInHours = new Time(5, 30)
val timeBeforeInHours2 = new Time(4)
val timeBeforeInMinutes = new Time(6, 19)
time.isBefore(timeAfterInHours) // true
time.isBefore(timeAfterInMinutes) // true
time.isBefore(timeBeforeInHours) // false
time.isBefore(timeBeforeInMinutes) // false
time.isBefore(timeBeforeInHours2) // false

timeAfterInHours.hours
timeAfterInHours
timeAfterInHours.minutes = 33
timeAfterInHours

time < timeAfterInHours
time < timeBeforeInHours

time - timeBeforeInMinutes
val easyTime = Time(15, 21)