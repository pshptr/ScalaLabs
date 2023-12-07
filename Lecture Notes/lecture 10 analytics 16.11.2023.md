## Лекция 16.11.2023

... назание лекции

фотка
...

* Функция top() возвращает указанное количество наибольших элементов из RDD в порядке убывания. Если указано значение n, то будет возвращено n наибольших элементов.

		val listRDD = sc.parallelize(List(1, 2, 3, 4, 5, 3, 2))
		val topElements = listRDD.top(3)
		// Output
		topElements:Array[Int] = Array(5, 4, 3)

* Функция take() возвращает указанное количество наибольших элементов из RDD в порядке, в котором они расположены в исходном наборе данных. Если указано значение n, то будет возвращено не более n элементов. Например:

		val takenElements = listRDD.take(3)
		// Output
		takenElements:Array[Int] = Array(1, 2, 3)

* union(otherRDD) - возвращает новый RDD, содержащий элементы как из RDD, так и из otherRDD.
* subtract(otherRDD) - возвращает новый RDD, который содержит элементы в RDD, но не в otherRDD.
* cartesian(otherRDD) - возвращает декартово произведение элементов RDD и otherRDD.
* map(func) - применяет функцию func к каждому элементу RDD и возвращает новый RDD с преобразованными элементами.
* flatMap(func) - применяет функцию func к каждому элементу RDD и возвращает сглаженный RDD с результирующими элементами. Возвращенный набор данных вернет больше строк, чем текущий.

#### Пример:

	val listRDD = sc.paralelize(List(1, 2, 3, 4, 5, 3, 2))
	val listRDD2 = sc.paralelize(List(1, 2, 6, 8, 5, 10, 2))
	val listRDD3 = listRDD3.union(listRDD2)
	val data:Array[Int] = listRDD3.collect()data.foreach(println)

... photka

val listRDD = sc.paralelize(List("Hello, World", "Spark is awesome"))
val wordsRDD = rdd.flatMap(line => line.split(" "))
println("wordsRDD: " + wordsRDD.collect().mkString(","))
// Output
wordsRDD: Hello, Wolrd, Spark, is, awesome


#### Пример чтения и запси в файл:

	import scala.io.Source
	import java.io.PrintWriter
	
	object FileInputOutputExample {
		def main(args:Array[String]): Unit = {
	 		// Reading from a file
	   		val filename "example.txt"
	     		val file = Source.fromFile(filename)
	       		for(line <- file.getlines) {
		 		println(line)
	    		}
			file.close()
	   		// Writing to a file
	    		val outputFilename = "output.txt"
	     		val writer = new PrintWriter(outputFilename)
	      		writer.write("Hello, world!\n")
	       		writer.write("This is an example of writing to file")
		 	}


### Scala приложения для обработки текста
Библиотека Apache OpenNLP - это основанный на машинном обучении инструментарий для обработки теста на естественном языке.
Natural Language Processing (NLP) - это область компьютернной науки котоая занимается взаимодействием и между компьютером и естесвенным человеческим языком.

#### Задачи NLP:

* Токенизация: разделение текста на отдельные слова или токены.
* Определение частей речи: существительное, глагол, прилагательное и т.д.
* Лемматизация: приведение слова к его базовой форме (например, приведение слова "бежал" к форме "бежать").
* Разбор синтаксических деревьев: анализ структуры предложения и определение связей между словами. 
* Распознование именованных сущностей: выделение и классификация именованных сущностей в тексте (имена людей, организации, места и т.д.).
* Классификация текста: автоматическое присвоение тексту определенной категории или метки (например, определение тональности текста, определение темы и т.д.)
* Машинный перевод: овтоматический перевод текста с одного языка на другой и т.д.
  

 * Находим файл JAR с именем opennlp-tools-1.8.0.jar. Сидит в подписке lib.
 * Распаковываем его по пути, где лежит Scala (добавляем туда каталог opennlp).
Через Google скачиваем ещё 2 файла:
* en-token.bin
* en-ner-person.bin
+ Нужно вытянуть из врхива openNLP.jar 2 файла:
  * opennlp-tools-1.8.0.jar
  * TokenizerModel.class
 
#### Пример выполнения именованного распознавания сущностей в тексте на английском языке:

	import java.sq;.{Connection, DriverManager, ResultSet}
	import java.io.FileInputStream
	import opennlp.tools.namefind.{NameFinderME, TokenNameFinderModel}
	import opennlp.tools.tokenize.*
	import opennlp.tools.util.Span
	
	object Main25 {
		def main(args:Array[String]):Unit = {
	 		// Load tokenizer model
	   		val tokenizerModelIn = new FileInputStream("en-token.bin")
			val tokenizerModel = new 						   opennlp.tools.tokenize.TokenizerModel(tokenizerModelIn)
	  		val tokenizer = new new opennlp.tools.tokenize.TokenizerME(tokenizerModel)
	    		// Load NER model
	      		val nerModelIn = new FileInputStream("en-ner-person.bin")
			val ner = new NameFinderME(nerModel)
	
	  		// Define some sample text
	    		val text = "John Smith is a software engineer at Google."
	
	      		// Tokenize the text
			val tokens = tokenizer.tokenize(text)
	
	  		// Find the named entities in the text
	    		val spans = ner.find(tokens)
	
	      		// Print the named entities and their types
			for(span <- spans) {
	  			val entityType = span.getType
	     			val entity = tokens.slice(span.getStart, span.getEnd).mkString("")
				println(s"$entityType: $entity")
	   		}
	     	   }
	      }