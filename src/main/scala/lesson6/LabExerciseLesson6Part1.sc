val zones = java.util.TimeZone.getAvailableIDs
val zonesStartingWithLetterK = zones.map(s => s.split("/"))
  .filter(a => a.length > 1)
  .map(a => a(1))
  .groupBy(_.substring(0, 1))("K")

zonesStartingWithLetterK.foreach(println(_))