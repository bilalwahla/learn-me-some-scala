val words = Array(
  "Mary", "had", "a", "little", "lamb", "its", "fleece", "was",
  "white", "as", "snow", "and", "everywhere", "that", "Mary",
  "went", "the", "lamb", "was", "sure", "to", "go"
)
val groupedByFirstLetter = words.groupBy(_.substring(0, 1))
groupedByFirstLetter("w")
val groupedBySameLength = words.groupBy(_.length)
groupedBySameLength.getOrElse(4, 0)