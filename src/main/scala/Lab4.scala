// Загрузка текстового файла
val textFile = spark.sparkContext.textFile("textscala.txt")

// Определение регулярных выражений
val stopWords = "\\b(the|and|is|in|it|of|to|a)\\b".r
val carOrAvtoPattern = "\\b(car|avto)\\b".r
val myPattern = "\\b.*my\\b".r
val thirdLetterDPattern = "\\b..d.*".r
val threeOrMoreVowelsPattern = "\\b.*[aeiouAEIOU].*[aeiouAEIOU].*[aeiouAEIOU].*\\b".r

// Фильтрация и обработка данных
val words = textFile.flatMap(line => line.split("\\s+"))
val filteredWords = words.filter(word => !stopWords.pattern.matcher(word.toLowerCase).find)
val carOrAvtoWords = filteredWords.filter(word => carOrAvtoPattern.findFirstIn(word.toLowerCase).isDefined)
val myWords = filteredWords.filter(word => myPattern.findFirstIn(word.toLowerCase).isDefined)
val thirdLetterDWords = filteredWords.filter(word => thirdLetterDPattern.findFirstIn(word.toLowerCase).isDefined)
val threeOrMoreVowelsWords = filteredWords.filter(word => threeOrMoreVowelsPattern.findFirstIn(word.toLowerCase).isDefined)

// Вывод результатов
filteredWords.collect().foreach(println)
carOrAvtoWords.collect().foreach(println)
myWords.collect().foreach(println)
thirdLetterDWords.collect().foreach(println)
threeOrMoreVowelsWords.collect().foreach(println)

val secondWord = filteredWords.take(2).last
println(secondWord)