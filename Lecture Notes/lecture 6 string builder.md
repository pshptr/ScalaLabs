### Функции для рабоыты со строками 

#### Класс StringBuilder и класс String представляют разные подходы к работе с текстовыми данными в Java. 
Отличия между ними: 
1. объекты класса String являются неизменяемыми. Такие операции надо строкой как компетинация, замена символа создаёт новый объект строки, в то время как объекты класса StringBuilder являются изменяемыми, их можно изменять не создавая новые объекты, что позволяет сэкономить памить.
2. Отличаются своими методами, StringBuilder помимо базовых (ужаление, добавление) содержит свои методы для вставки, удаления, добавлени.

#### Например: (методы StringBuilder)
1. append(x:Any):StringBuilder добавляет строковое представление заданного значения x в конец строки.
2. insert(index: Int, x:Any):StringBuilder вставяляет строковое представление заданного значения x по указанному индексу, возвращает уже изменённое значение StringBuilder.
3. delete(start: Int, end:Int):StringBuilder удаляет значения в диапазоне от start до end (start включительно, end не включительно), возвращает уже изменённое значение.
4. replace(start: Int, end: Int, str:String):StringBuilder заменяет символы в диапазоне от start до end заданной строки (start включительно, end не включительно), возвращает уже изменённое значение.
5. reverse

  ```scala

		object main22{
		def main(args:Array[String]):Unit = {
		 val sb = new StringBuilder()
		 sb.append("hello")
		 sb.append("")
		 sb.append("world")
		 sb.appendAll(Seq('!', '!', '!'))
		 sb.insert(5, "there")
		 sb.delete(0, 6)
		 sb.replace(5, 11, "Scala")
		 val reversed = sb.toString.reverse
		
		 println(reversed) = sb.toString.reverse !!!alacSereht
 ```

 Класс String предоставляет следующий набор функций для работы со строками:
 ##### replaceAll
 Используется для замен ывсех вхождений в  строку другой строкой имеет 2 аргумента заменяемое и строка замены
 Пример:
 ```scala

    val str = "Hello Wolrd"
    val newStr = str.replaceAll("o", "a")
    println(newStr) // "Hella, Warld!"
 ```

##### split 
Используется строки на массив подстрок на основе разделителя. Аргумент у функциии 1 - раделитель
Пример:
 ```scala

    val str = "Hello Wolrd"
    val arr = str.split(",")
    println(arr.mkString(" ") // "apple banan orange"
 ```

##### startsWith, enddsWith
Функция используется для проверки того начинается или закнчивается строка заданной полстрокой. В качестве аргумента заменяемая строка
Пример:
 ```scala

    val str = "apple,banana,orange"
    println(str.startsWith("Hello")) // true
    println(str.endsWith("!") // true
 ```

##### subString
 Выделяет подстроку из строки (нумерация идё с 0)
 Пример:
  ```scala

    val str = "Hello Wolrd"
    val subStr = str.substring(7, 12)
    println(sub.Str)
 ```

##### toLowerCase, toUpperCase
Изменяет регистры из верхнего к нижнему и наоборот.
 Пример:
  ```scala

    val str = "Hello Wolrd" 
    println(str.toLowerCase) // "hello world"
    println(str.toUpperCase) // "HELLO WORLD"
 ```

##### trim
Отсекает концевые пробелы из конца строки и из начала строки
 Пример:
  ```scala

    val str = " Hello Wolrd "
    println(str.trim) // "Hello World"
 ```

##### indexOf, lastIndexOf
Получает 1-й и последний индекс подстроки в строке (то есть номер позиции с которой начинается подстрока).
 Пример:
  ```scala

    val str = "Hello Wolrd"
    println(str.indexOf("o")) // 4
    println(str.lastIndexOf("o")) // 8
 ```

##### toCharArray
Преобразует строку в массив символов.
Пример:
  ```scala

	 val str = "Hello Wolrd"
	 val arr = str.toCharArray
	 println(arr.mkstring("")) // [Hello World]
  ```

##### charAt
Определяет символ стоящий на указанной позиции (нумерация с нуля, пробел учитывается).
Пример:
  ```scala

	val str = "Hello, World!"
	println(str.charAt(7)) // 'W'
  ```

##### stripMargin
Используется для удаления отступов (марген) из многострочных строк. При исползовании этой функции каждая строка в многострочной строке должна начинаться с символа вертекальной черты, отступы в этом случае будут удалены, вертикальная черта даёт выравнивание по левому краю.
Пример: 
  ```scala

	val str = 
	"""
	| Hello
	| World
  ```

##### toInt
Используется для пареобразования строки в целое число. При преобразовании может возникнуть ошибка если строка например не 123 а abc тогда будет ошибка которую необходимо перехватить
Пример:
  ```scala

	object Main22{
	def main(args:Array[String]):Unit = {
	val str = "123"
	val num = str.toInt
	println(num) // 123
  ```

##### toDouble
Преобразует строку в число с плавающей точкой.
Пример:
  ```scala

	object Main22 {
	def main(args:Array[String]):Unit = {
	val str = "3.14"
	val num = str.toDouble
	println(num) // 3.14
	val str2 = "abc"
	try {
	val num = str2.toDouble
	println(num)
	} catch {
	case e = NumberFormatException => println("Envalid Number Format") }}}
  ```

##### getBytes()
Пркобразует строку в массив байт.
Пример: 
  ```scala

	val str = "Hello World"
	val bytes = str.getBytes()
	println(bytes.mkString("")) // 72 101 108 108 111 44 32 87 111 114 108 100 33
  ```

И наоборот из массива байтов в строку. 
Пример: 
  ```scala

	object Main22 {
	def main(args:Array[String]):Unit = {
	val bytes = Array[Byte](72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33) // bytes corresponding to hello
	val str = new String(bytes, "UTF-8")
	println(str)
	}
	}
  ```
