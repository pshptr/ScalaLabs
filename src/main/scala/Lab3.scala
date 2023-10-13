import scala.util.matching.Regex

object TextProcessingApp {
  def main(args: Array[String]): Unit = {
    val text0 = "Hello, Scala 3 !"
    val countedText = vowelsCount(text0)
    println("0. Количество гласных в тексте: " + countedText)

    val text1 = "Hello to everybody"
    val replacedText = replaceLatinWithRussian(text1)
    println("1. Замененный текст: " + replacedText)

    val text2 = "When executing the exercise extract all extra words"
    val extWords = findWordsStartingWithExt(text2)
    println("2. Слова, начинающиеся на 'ext': " + extWords.mkString(", "))

    val text3 = "A big round ball fall to the ground"
    val replacedText3 = replaceTheWithA(text3)
    println("3. Текст с замененными артиклями: " + replacedText3)

    val text4 = "A big round ball fall to the ground"
    val reversedText = reverseWords(text4)
    println("4. Текст с обратным порядком слов: " + reversedText)

    val text5 = "Hello to everybody"
    val textWithoutVowels = removeVowels(text5)
    println("5. Текст без гласных: " + textWithoutVowels)

    val text6 = "Hello to everybody"
    val doubledText = doubleEachLetter(text6)
    println("6. Текст с удвоенными буквами: " + doubledText)

    val text7 = "Hello to everybody"
    val textWithoutY = removeLetterY(text7)
    println("7. Текст без буквы 'y': " + textWithoutY)

    val text8 = "Hello to everybody"
    val insertedText = insertWords(text8, "with heartness", 1)
    println("8. Текст с вставленными словами: " + insertedText.mkString(" "))

    val text9 = "Additional task"
    val tripledText =  tripleSymbol(text9)
    println("9. Текст с утроенными символами: " + tripledText)

    val text10 = "Additional task 2"
    val removedSpaceText = removeSpace(text10)
    println("10. Текст с удалёнными пробелами: " + removedSpaceText)

    val text11 = "Replace"
    val replacement = "kkk"
    val replacedLettersText = replaceFirstThreeLetters(text11, replacement)
    println("11. Слово с заменёнными первыми тремя буквами: " + replacedLettersText)

    val text12 = "Remove special !@#$%^&*()_+= symbols"
    val removedSpecialSymbolsText = removeSpecialCharacters(text12)
    println("12. Текст с удалёнными специальныими символами: " + removedSpecialSymbolsText)

  }
    def replaceLatinWithRussian(text: String): String = {
      val regex: Regex = """[a-zA-Z]""".r
      regex.replaceAllIn(text, { c => (c.toString + 32).toString })
}

  def findWordsStartingWithExt(text: String): List[String] = {
    val extWordsRegex = "\\bext\\w*".r
    extWordsRegex.findAllIn(text).toList
  }

  def replaceTheWithA(text: String): String = {
    text.replaceAll("\\bthe\\b", "a")
  }

  def reverseWords(text: String): String = {
    text.split(" ").reverse.mkString(" ")
  }

  def removeVowels(text: String): String = {
    text.replaceAll("[aeiouAEIOU]", "")
  }

  def doubleEachLetter(text: String): String = {
  val regex: Regex = """\w""".r
   regex.replaceAllIn(text, { m => m.group(0) + m.group(0) })
  }

  def removeLetterY(text: String): String = {
    text.replaceAll("y", "")
  }

  def insertWords(text: String, wordsToInsert: String, position: Int): String = {
    val text: String = "Hello to everybody"
    println("Source: " + text)
    val regex: Regex = """\bto\b""".r
    regex.replaceAllIn(text, "with heartness to")
  }

  def vowelsCount(text: String): Int = {
    val regex: Regex = """[aeiouyAEIOUY]""".r
    regex.findAllMatchIn(text).length
  }

  def tripleSymbol(text: String): String = {
    val regex: Regex = """t""".r
    regex.replaceAllIn(text, "ttt")
  }

  def removeSpace(text: String): String = {
    val regex: Regex = """ """.r
    regex.replaceAllIn(text, "")
  }

  def replaceFirstThreeLetters(text: String, replacement: String): String = {
    val regex = "\\b(\\w{3})(\\w*)\\b".r
    regex.replaceAllIn(text, m => replacement + m.group(2))
  }

  def removeSpecialCharacters(input: String): String = {
    input.replaceAll("[!@#$%^&*()_+=]", "")
  }

}
