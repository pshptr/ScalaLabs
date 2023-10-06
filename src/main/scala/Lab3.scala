object TextProcessingApp {
  def main(args: Array[String]): Unit = {
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
  }

  def replaceLatinWithRussian(text: String): String = {
    val replacementMap = Map(
      'H' -> 'Н', 'e' -> 'е', 'l' -> 'l', 'o' -> 'о',
      't' -> 'т', 'o' -> 'о', ' ' -> ' ', 'e' -> 'е',
      'v' -> 'v', 'r' -> 'г', 'y' -> 'у', 'b' -> 'ь',
      'd' -> 'd', 'y' -> 'у'
    )
    text.map(char => replacementMap.getOrElse(char, char))
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
    text.flatMap(char => s"$char$char")
  }

  def removeLetterY(text: String): String = {
    text.replaceAll("y", "")
  }

  def insertWords(text: String, wordsToInsert: String, position: Int): String = {
    val words = text.split(' ')
    if (position >= 0 && position <= words.length) {
      val (before, after) = words.splitAt(position)
      (before :+ wordsToInsert).mkString(" ") + " " + after.mkString(" ")
    } else {
      text // Return original text if position is invalid
    }
  }
}