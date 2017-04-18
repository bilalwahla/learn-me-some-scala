def isVowel(c: Char) = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
isVowel('a')

def isVowel2(c: Char) = "aeiou" contains c
isVowel2('e')

def vowels(s: String) = {
  var result = ""
  for (c <- s) {
    if (isVowel2(c)) result += c
  }
  result
}
vowels("Bilal, Zobia and Anaya")

def vowels2(s: String) = for (c <- s if isVowel2(c)) yield c
vowels2("Bilal, Zobia and Anaya")

def vowels3(s: String): String = {
  if (s.length == 0) ""
  else {
    val c = s(0)
    val rest = vowels3(s.substring(1))
    if (isVowel2(c)) c + rest else rest
  }
}
vowels3("Bilal, Zobia and Anaya")

def vowels4(s: String) = {
  var result = ""
  var i = 0
  while (i < s.length) {
    val c = s(i)
    if (isVowel2(c)) result += c
    i += 1
  }
  result
}
vowels4("Bilal, Zobia and Anaya")

def isVowel3(c: Char, vowelChars: String) = vowelChars contains c

def vowels5(s: String, vowelChars: String = "aeiou", ignoreCase: Boolean = true): String = {
  if (ignoreCase) vowels5(s.toLowerCase, vowelChars, ignoreCase = false)
  else for (c <- s if isVowel3(c, vowelChars)) yield c
}
vowels5("Bilal, Zobia and Anaya")