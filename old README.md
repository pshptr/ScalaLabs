# Лекции Scala 

## первая лекция 
## ЛК1 ФПрогр Принципы функциональной парадигмы (ФП). Обзор. Современное состояние ФП.

### Функциональное программирование - это парадигма программирования, в которой основное внимание уделяется использованию функций как основных строительных блоков программного обеспечения.

Языки ФП обычно предоставляют такие ф-ии, как ф-ии высшего порядка, лямбда выражения. Примеры языков ФП включают Hаskel, Lisp, ML и Scala. Однако многие другие языки, такие как Python, JavaScrypt и Java, также в некоторой степени поддерживают ФП. В том числе андроид студия поддерживает скала. 
ФП уходит своими корнями в лямбда исчисления математическую нот ацию разработанную черчем в 30 года 50-60 годы был разработан язык лисп который считается первым языком функционального программирования 70-80 фп приобркло популярность в академичесокм сообщестьве (языки мирандар, мл и тд.), в 90-ч годах в связи с развитием промышленности получили развитие как хаскел и scheme. Сегодня уже используются скала фшарп кложуре. ФП используется на практике например в обработке больших данных поскольку делает упор на неизменяемость и параллелизм. Второе это вэб разработка чаще используетяс для создания интерфейсых приложений треть е фигнансовое моделирование разработка игр(например юнити использует фп для своего языка сценариев). Машинное обучение.

### Ключевые Концепции ФП
1. Использование чистых функций - которая не имеет побочных эффектов возвращают одни и теже выходные данные при одних и тех жке входных. 
2. Неизменяемость, ФП отдаёт предпочтение неизменяемым структурам данных, те кот нельзя изменить после создания, это упрозает код анализ кода
3. Ф-ии высшего порядка, это ф-ии кот принимают др ф-иив качве входных данных или возвращает ф-ии в качве выходных данных 
4. Рекурсия, вызов ф-ии самой себя 
5. Ленивые вычисления, это метод при кот выражения не вычисяются до тех пор пока они не будут востребованы это может сэкономить время вычисления и память
6. Монады, это способ вычисления в виде последовательности шагов при этом гарантируется что каждый шаг выполняется в опрерделенном порядке и определенном контексте 

Скала является масшабируемым языком программирования потому что он был разраотан с нуля для крупномасштабной разработки ПО. Способен справляться с растущим объёмом данных без ущерба для производительнрости или надёжности, в час ности используется в больших данных и облачных вычислениях. сочетает в себе ф-ии ООП, ФП. В скала есть
1. строгая статическая типизация то есть позволяет компилятору обнаружить ошибки ещё до выполнения программы 
2. поддержка параллелизма, позволяет упрощать нааписание кода способного асинхронно обрабатывать несколько потоков и событий 
3. совместимость с джава, работает на джэвээм может взаимодействовать с кодом и библиотеками джава 

пример 1:

	object Main22{
	
	val f:(Int=>Int) = {
		val p=10
		val q=20
		x=> p+q*x
	}
	
	def main(args: Array[String]): Unit = {
		val t=f(4)
		println(t)
	}
	
	}


### Прогназирование

### Простейшие примеры программ на Scala

Пример программы, вычисляющей сумму двух числе:

object 

### 2 тема 
Существует несколько тем интегрированных сред разработки IDE поддерживающих разработку программ на скала Интелиж идея, Эклипс, ВС код,  Скала ИДЕ. Object  это считается как целый класс
Модули обычно используются в скала для и др глобальных обьектов 

Пример взаимодействия класов внутри модуля

    object MyModule {
      class MyClassA(val name: String){
        def greet(): Unit = println(s"Hello from $name!")
    
        def callB(b: MyClassB): Unit = {
          println(s"name is calling $(b.name)")
          b.greet()
        }
      }
    }

    class MyClassB(val name: String){
      def greet():Unit = println(s"Hello from $name!")
    
      def callA(a: MyClassA):Unit = {
        println(s"$name is calling ${a.name}!")
        a.greet()
      }
    }
    
    object Main {
      def main(args:Array[String]):Unit = {
        val a = new MyModule.MyClassA("Alice")
        val b = new MyModule.MyClassB("Bob")
    
        a.callB(b)
        b.callA(a)
      }
    }

---

В Scala конструкторы используются для создания экземпляров классов
Бывают два типа:
1) Первичные (основные)
2) Вспомогательные 

Первичный конструктор определяется, как часть определения класса и выполняется при создании экземпляра класса
Параметры основного конструктора определены в определении класса (Имя конструктора = имени класса)

    // Пример с первичным конструктором
    class MyClass(val name: String, val age: Int) {
      println("Creating instance of MyClass")
      def greet():Unit = println()
    
      // .....
    }

Вспомогательный конструктор могут иметь другие списки параметров, чем у основного. Определеются с помощью ключевого слова this, должны вызывать либо первичный конструктор, либо другой вспомогательный конструктор в качестве своего первого оператора

    // Пример со вспомогательным конструктором
    class MyClass(val name: String, val age: Int) {
      def this(name:String) = this(name, 0)
    
      println("Creating instance of MyClass")
      def greet():Unit = println(s"Hello, $name and $age years old")
    }

Вспомогательный конструктор вызывает основной конструктор с параметром name и значением по умолчанию (0)

    // Со вспомогательным конструктором
    
    object Main {
        def main(args: Array[String]):Unit = {
        val myObject2 = new MyClass("Jane")
        myObject2.greet() // print greet
      }
    }

Чтобы создать экземпляр класса с помощью вспомогательного конструктора можно использовать ключевое слово new за которым следует имя класса и параметры вспомогательного конструктора.

Пример чтения файлов и вывода его содержимого на консоль

    import java.io._
    
    class MyClass {
      // Initialize resources
      val fileHandle = new File("data.txt") // открывает файл для чтения
      val fis = new FileInputStream(fileHandle)
      val bis = new BufferedInputStream(fis) // читается блок байтов в память
      val dis = new DataInputStream(bis) // чтение данных
    
      try {
        while(dis.available() != 0) {
          val line = dis.readLine()
          println(line)
        } } catch {
          case e: IOException =>
            println("An error occured while reading the file:" + e.getMessage)
        }
        finally {
          dis.close()
          println("reading closed")
        }
      }
    
      override def finalize(): Unit = {
        super.finalize()
      }
    }
    
    object Main {
      def main(args: Array[String]): Unit = {
        val myObjest2 = new MyClass
        myObject2.finalize()
        println("ok")
      }
    }
    
    Пример смешения трейтов
    
    trait Flyable {
      def fly(): Unit = {
        println("Flying...")
      }
    }
    
    trait Swimmable {
      def swim(): Unit = {
        println("Swimming...")
      }
    }
    
    trait Walkable {
      def walk(): Unit = {
        println("Walking...")
      }
    }
    
    class Animal extends Flyable with Swimmable with Walkable
    
    object Main {
      def main(args: Array[String]): Unit = {
        val animal = new Animal
        animal.fly
        animal.swim
        animal.walk
      }
    }
    
    Функции и мтоды для работы со списками
    \(\bullet\) :: добавляет элемент в начало списка 
    \(\bullet\) :+ добавляет элемент в конец списка 
    \(\bullet\) ++ объединение списков 
    \(\bullet\) head элемент начала списка 
    \(\bullet\) tail список без головы
    \(\bullet\) isEmpty проверяет список на пустоту (true or false)
    \(\bullet\) length возвращает длину списка 
    \(\bullet\) contains проверяет существует ли в списке заданный элемент (true or false)
    \(\bullet\) distinct возвращает новый список, содержащий уникальные элементы списка 
    
    Map (карта, отображение) 
    функция применяет заданную функцию к каждому элементу списка и возвращает новый список
    
    def double(x: Int): Int = x * 2
    
    def main(args: Array[])
    
  ---
    
    filter: функция фильтер отбирает элементы списка удовоетворяющие заданному условию
    
    filter 
    object Main22 {
    def isEven(x: int): Boolean = x
    
    reverse возвращает список в обратном порядке
    
    object Main51 {
    
    def main(args: Array[st
    
    foldLeft:
    
    Синтаксис следующий
    
    collection.foldLeft(initialValue)(binaryOperator)

Функция поледовательно пр меняется к элементам списка слева направо накапливая результат
Collection эта коллекция над которой выполняется операция свёртки. initial value  это начальное значение аккумудятора или результата, бинарный оператор который обьеденяет каждый элемент коллекции и аккумулятор, работает с разными видами коллекций. 

пример суммы элементов списка:
	
	object Main22 {
	def main(args: Array[String]): Unit = {
	val myList
…

### zip: функция обьеденяет 2 списка н апримере словаря ключ-значение

	val a = List(1, 2, 3)
	
	
	object Main22 {
	def main(args: Array[String]): Unit = {
	 val a = List(1, 2, 3)
	 val b = List(«one», «two», «three»)
	 val zipped = a
…

zip применяем при  элементы двух списков обьеденяется в пары в результате получается список кортежей дальше применяется фильтрация каждому элементу списка если условие выполняется true мы оставляем эту пару в списке

Можно выводить элементы вот так:

	zipped.foreach {case (a,b) => println…
	// one
	//two
	//three

Примеры

Сумма элементов списка 

	object Main 22 {
		def sumLIst(Ist: List[Int]): Int = {
			if(Ist:isEmpty) 0
			else Ist.head + sumList(Ist.tail
	…
при работе со списками используется рекурсия практически всегда, для этого у нас есть несколько веток для работы со списками первая ветка относится к простейшим случаям, к пустым спискам, к спискам с одним элементом, с головой списка. Последующие ветки относятся к более общему случаю и имеют следующее назначение: если список нее соответствует простейшему случаю, то следует уменьшить его на один элемент и применить рекурсию к укороченному списку и при этом в памяти сохраняется информацию о том что обработка предыдущего вызова функции ещё не закончена. 

Примеры:

Подсчёт кол-ва эл-ов списка

object Main22 {

def sizeList
…

Минимальный элемент списка:
	
	import scala.io.Stdln
	
	object Main28 {
		def minList(Ist: List[Int], minval: Int): Int = {
			if (Ist.isEmpty) minval
			else if (Ist.head < minval) minList(Ist.tail, Ist.head)
			else minList(Ist.tail, minval)  }

Минимальный элемент списка: 

def main(args: Array[String]): Unit = {
	var myList = List.empty[Int]
	
	var input = Stdln.readLine()
	while (input.nonEmpty) {
		val element = input.toInt
		myList = element :: myList
		input = Stdln.readLine() }

	if (myList.isEmpty) {
		println(«The list is empty»)
	} else {
	val minw = minList(myList, myList.head)
	println(minw)  } }}

Отыскание элемента по индексу:
	
	object Main22 {
	def posList(Ist: List[Int], pos: Int): Int = {
	…
	
	
	Строки
	
	Операции со строками 
	
	val s1 = «hello»
	val s2 = «world»
	
	// Concetanation
	val s3 = s1 + «» + s2 // «hello world»
	
	// Length
	val len = s3.length // 11
	
	// Substring
	val sub = s3.substring(0, 5) // «hello»
	
	// Replace
	val replaced = s3.replace(«hello», «hi») // «hi world»
	
	// Split
	val parts = s3.split(«») // hello, world

### String это неизменяемый класс это значит что после создания строки её значение нельзя изменить. Строки мы можем передавать и возвращать как аргумент функции.


## Развитые типы функций. Операторы

Класс содержащий 1 или несколько абстрактных методов должен быть обьявлен как абстрактный. Абстрактные классы также могут иметь не абстрактные методы с реализацией. Абстрактный метод - метод который обьявлен и не имеет реализации в том же классе вместо этого реализация метода откладывается до подкласса, ключевое слово abstract. 

	abstract class Animal {
		def makeSound(): Unit
	}
	class Dog extends Animal {
		def makeSound(): Unit = {
		println(«Woof-fff»)
		}
	}
	class Cat extends Animal {
		def makeSound(): Unit = {
		println(«Mia-uuu»)
		} 
	}
	
	object Main22 {
	
	def main(args: Array[String]: Unit = {
		val myDog = new Dog
		myDog.makeSound()
		val MyCat = newCat
		myCat.makeSound()
	
	
	abstarct class Animal {
		def makeSound1 (): Unit = {
			println(«Po»)
		}
	}
	class Dog extends Animal


Частично применимые ф-ии можно создавать, т.е. ф-ии которые  принимают некоторые, но не все свои аргументы, то есть она применяется к части своих аргументов

	object Main22 {
	
	def add(x: Int, y: Int, z: Int): Int = { // частично применимая ф-я
		x + y + z
	}
	
	def main(args: Array[String]): Unit = {
		val addTwo = add(_: Int, 2, _: Int)
	
		val result2 = addTwo(3, 5) // result is 10
		println(result2)
		}
	}

Частично применимые ф-ии можно создавать при помощи лямбда выражений которые являются анонимными ф-ями

	val multiplyByTwo: Int => int = _ * 2
	val result = multiplyByTwo(5)

Частично применимые ф-ии полезны когда хотим создать ф-ии которые похожи но имеют некоторые различия в своих аргументах. Их используют для создания ф-ий более высокого порядка и для передачи ф-ий в кач-ве аргумента другим функциям. Ленивые вычисления тоже есть в Scala, они определяются ключевым словом lazy val. lazу val - это значение которое оценивается только при первом доступе к нему. Полезно когда есть затратная вычислительная операция которую мы не хотим выполнять пока она не потребуется. 

### Ленивые вычисления

    object Main22 {
    
    def main(args: Array[String]): Unit = {
    	def expensiveOperation(param: Int): Int = {
    		println(«Выполняется дорогостоящая операция для параметра» + param)
    	// Возвращаем результат
    	factorial(param)
    }
    def  factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
    }

Определяем в примере две переменны result1 и result2 обе из которых ссылаются на expensive operation. В первый раз когда осуществляется вызов expensive operation  когда выполняется эта операция второвй раз когд аввызывается наша дорогостоящая операция она больше не выполняется а из памяти возвращается результат // 42.  Как только лейзи вал оценивается его значение фиксируется и его значение не может быть изменено если нужно выплниьт дорогостоящ операцию несколько раз с разными параметрами нужно использовать функцию вместо отложенного val. 

Когда фиксируеся лейзи вал то его значение нельзя изменить.
Если нужно выыполнить какую-то дорогостоящую операцию несокльок раз с разнными параметрами, то необходимо использовать функцию вмест val.

     object main22 {
      def main(args: Array[String]): Unit = {
       def expenseiveOperarion(param:Int):Int = {
        println("Выполняется дорогостоящая операция для параметра" + param)
        // Возвращаем результат
           factorial(param)
         }
         def factorial(n: Int):Int = {
          if(n <= 1)1
          else n * factorial(n - 1)
        }
        // Функция, которая будет вызывать дорогостоящую операцию с разными параметрами
        def perfomOperations():Unit = {
         val params = List[5, 7, 10]

         params.foreach { param => 
          val result = expensiveOperation(param)
          println("Результат для параметра" + param + ":" + result)
          }
         }
         perfomOperations()
        }
       }

## Операторы

операторы...
побитвые ...
& (bitwise AND)
| (bitwise OR)
^ (bitwise XOR)
~ bitwise complement)
<< (left shift)
>> (right shift)

Операторы пользователя
   
    object main22 {
    def main(args:Array[String]: Unit = {
     case class MyClass(x:Int) {
      def @@(y: Int):Int = x + y
     }
    
     val a = MyClass(10)
     val b = a@@5 // equivalent to a.@@5
    
     println(b) // outputs 15
     }
    }

Пользовательские операторы можно определять с помощью символических имён, определяются точно также через def. 

### Замыкания 
Замыкание - это функция, которая захватывает среду в которой она определена включая любые переменные и функции находящяеся в области видимости во время её определения.
В Scala можно определять замыкания с помощью анонимных функций, например:

    val x = 10
    val addX = (y:Int) => x + y
    
    println(addX(5)) // outputs 15

Здесь addX которое захватывает значение x из внешней области и возвращает сумму этого значения и аргумента y. Символ => для анонимных функций используется, не только для лямбда выражений.

    object main22 {
    
    def add(x:Int, y:Int) = x + y 
    
    def main(args:Array[String]):Unit = {
     val add5 = (x:Int) => add(x, 5)
     println(add5(10)) // outputs 15
     }
    }

В этом примере add5 это замыкание которое захватывает функцию и возвращает результат, возвращает функцию которая добавляет 10 к 5, сложенеи x и y (add5 можно и в мейен и не в мейн).


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

 Класс String предоставляет следующий набор функций для работы со строками:
 ##### replaceAll
 Используется для замен ывсех вхождений в  строку другой строкой имеет 2 аргумента заменяемое и строка замены
 Пример:

    val str = "Hello Wolrd"
    val newStr = str.replaceAll("o", "a")
    println(newStr) // "Hella, Warld!"

##### split 
Используется строки на массив подстрок на основе разделителя. Аргумент у функциии 1 - раделитель
Пример:

    val str = "Hello Wolrd"
    val arr = str.split(",")
    println(arr.mkString(" ") // "apple banan orange"

##### startsWith, enddsWith
Функция используется для проверки того начинается или закнчивается строка заданной полстрокой. В качестве аргумента заменяемая строка
Пример:

    val str = "apple,banana,orange"
    println(str.startsWith("Hello")) // true
    println(str.endsWith("!") // true

##### subString
 Выделяет подстроку из строки (нумерация идё с 0)
 Пример:

    val str = "Hello Wolrd"
    val subStr = str.substring(7, 12)
    println(sub.Str)

##### toLowerCase, toUpperCase
Изменяет регистры из верхнего к нижнему и наоборот.
 Пример:

    val str = "Hello Wolrd" 
    println(str.toLowerCase) // "hello world"
    println(str.toUpperCase) // "HELLO WORLD"

##### trim
Отсекает концевые пробелы из конца строки и из начала строки
 Пример:

    val str = " Hello Wolrd "
    println(str.trim) // "Hello World"

##### indexOf, lastIndexOf
Получает 1-й и последний индекс подстроки в строке (то есть номер позиции с которой начинается подстрока).
 Пример:

    val str = "Hello Wolrd"
    println(str.indexOf("o")) // 4
    println(str.lastIndexOf("o")) // 8

##### toCharArray
Преобразует строку в массив символов.
Пример:

	 val str = "Hello Wolrd"
	 val arr = str.toCharArray
	 println(arr.mkstring("")) // [Hello World]

##### charAt
Определяет символ стоящий на указанной позиции (нумерация с нуля, пробел учитывается).
Пример:

	val str = "Hello, World!"
	println(str.charAt(7)) // 'W'

##### stripMargin
Используется для удаления отступов (марген) из многострочных строк. При исползовании этой функции каждая строка в многострочной строке должна начинаться с символа вертекальной черты, отступы в этом случае будут удалены, вертикальная черта даёт выравнивание по левому краю.
Пример: 

	val str = 
	"""
	| Hello
	| World

##### toInt
Используется для пареобразования строки в целое число. При преобразовании может возникнуть ошибка если строка например не 123 а abc тогда будет ошибка которую необходимо перехватить
Пример:

	object Main22{
	def main(args:Array[String]):Unit = {
	val str = "123"
	val num = str.toInt
	println(num) // 123

##### toDouble
Преобразует строку в число с плавающей точкой.
Пример:

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

##### getBytes()
Пркобразует строку в массив байт.
Пример: 

	val str = "Hello World"
	val bytes = str.getBytes()
	println(bytes.mkString("")) // 72 101 108 108 111 44 32 87 111 114 108 100 33

И наоборот из массива байтов в строку. 
Пример: 

	object Main22 {
	def main(args:Array[String]):Unit = {
	val bytes = Array[Byte](72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33) // bytes corresponding to hello
	val str = new String(bytes, "UTF-8")
	println(str)
	}
	}


### Регулярные выражения в Scala
Они представлены классом scala.util.matching.Regex, который предоставляет множество методов для сопоставления строк и управления ими на основе регулярных выражений.
Пример:

	val regex = """(\d{3})-(\d{2})-(\d{4})""".r
	val str1 = "123-45-6789"
	val str2 = "abc-12-3456"
	
	val match1 = regex.FindFirstMatchin(str1)
	val match2 = regex.FindFirstMatchin(str2)
	match1 match {
	case Some(m) => println(s"Match found: ${m.group(0)}")
	case None => println("No match found")
	}
	match2 match {
	case Some(m) => println(s"Match found: ${m.group(0)}")
	case None => println("No match found")

Метод FindFirstMatchIn возвращает первое совпадение шаблона в заданной строке. В регулярных выражениях " . " означает любой символ кроме /n. "c.t" - любое выражение где c в начале, t в конце "cat, cut" будет соответствовать. Знак " ^ " в начале регулярного выражения он соответствует только тем строкам которые начинаются со слова указанного в шаблоне (^Hello - соответсвует слово Hello в начале стрки, [^abc] - все кроме abc...). " + " - повтор 1 или более раз, " - " - повторение 0 или болле раз. Регулярные выражения записываются в тройные кавычки.


### Современные среды разработки функциональных программ

...

### Создание проекта на основе класса 

	object Module5 {
	
	def main(args:Array[String]):Unit = {
		var car1 = new Car("Honda","City","1996");
	 	var car2 = new Car("Honda","Accord","1999");
		var car1 = new Car("Honda","Amaze","2015");
	 	println("Car details: " +car1.make + "" + car1.model + "" + car1.year "" + car1.color)
	   	println("Car details: " +car2.make + "" + car2.model + "" + car2.year "" + car2.color)
	 	println("Car details: " +car3.make + "" + car3.model + "" + car3.year "" + car3.color)
	}

Код класса: 

	class Car(makeOfCar: String, modelOfCar: String, yearOfCarL: Int) {
		var make: String = makeOfCar;
	 	var model: String = modelOfCar;
	  	var year: Int = yearOfCar;
	   	var color = "",
	    	def changeColor(colorOfCar: String) {
	    		color = colorOfCar;
	      		println("New color of car:" + color);
			}
   		car1.changeColor("Red")
    		car2.changeColor("Blue")
     		car3.changeColor("Green")
       		println("Updated car details: + car1.make + "" + car1.model + "" + car1.year + "" + car1.color")
	 	println("Updated car details: + car2.make + "" + car2.model + "" + car2.year + "" + car2.color")
  		 println("Updated car details: + car3.make + "" + car3.model + "" + car3.year + "" + car3.color")
	  }

	// Output:
	Car details: Honda City 1996
	Car details: Honda Accord 1999
	Car details: Honda Amaze 2015
	New color: Red
	New color: Blue
	New color: Green
	Updated car details: Honda City 1996 Red
	Updated car details: Honda Accord 1999 Blue
	Updated car details: Honda Amaze 2015 Green


   ### Создание приложений с визуальным интерфейсом
Создадим такое приложение с визуальным интерфейсом, будем использовать методы JFrame, JPanel, JLabel. Метод invokeLater используется для обеспечения того чтобы компоненты GUI создавались и модифицировались в потоке деспетчеризации событий, который является потоком обрабатывающим события пользовательского интерфейса в приложениях Swing. Компоненты создаются в main при обращении к ним.
Пример создания приложения: 

	import java.awt.event.{ActionEvent, ActionListener}
	import javax.swing.{JButton, JFrame, JPanel, SwingUtilities}
	
	object  ButtonModule {
	  def main(args: Array[String]): Unit = {
	    SwingUtilities.invokeLater(() => {
	      val frame = new JFrame("My Application")
	      frame.setSize(300, 200)
	      val panel = new JPanel()
	      val button = new JButton("Click me!")
	      panel.add(button)
	
	      frame.add(panel)
	      frame.setVisible(true)
	    })
	  }
	}

javax.swing - пакет представляющий набор классов и компонентов для создания GUI приложений на Java.
Слуiатель действий саоздаётся как анонимный внутренний класс который реализует интерфейс actionListener и переопhеделяет его в метод actionPerformed.

## лекция 02.11.2023
### Использование текстовых полей 

	import java.awt.event.{ActionEvent, ActionListener}
	import javax.swing.{JButton, JFrame, JPanel, SwingUtilities}
	object ButtonModule {
	def main(args: Array[String]): Unit = {
	SwingUtilities.invokeLater(() => {
	val frame = new JFrame("My Application") frame.setSize(300, 200) frame.setLocationRelativeTo(null)
	val panel = new JPanel()
	val button = new JButton("Click me!") panel.add(button)
	button.addActionListener(new ActionListener {
	override def actionPerformed(e: ActionEvent): Unit = {
	8
	println("Hello, world!")
	        }
	})
	      frame.add(panel)
	frame.setVisible(true) })
	} }

 Меню создаётся в 3 этапа: сначала полосу bar, затем размещаем на полосе пункты меню, затем в каждом пункте menu создаём опции, они называются menu item. 

 Создание простого меню в окне (фрейме)

	import java.awt.event.{ActionEvent, ActionListener}
	import javax.swing.{JButton, JFrame, JPanel, SwingUtilities}
	import javax.swing.{JFrame, JLabelm JTextField, JPanel, SwingUtilities}
	import java.awt.{Menu, MenuBar, MenuItem}
	
	object ButtonModule {
		def main(args:Array[String]):Unit = {
	 	SwingUtilities
	  ...
	
	  val fileMenu = new Menu("File")
	  menuBar.add(fileMenu)
	
	  val exitItem.addActionListener((_:java.awt.event.ActionEvent) => { frame.dispose() })
	
	  fileMenu.addItem(exitItem)
	  val panel = new JPanel()
	  val button new JButton("Click me!")
	  panel.add(button)
	
	  button.addActionListener(new ActionListener {
	  	override def actionPerfomed(e: ActionEvent):Unit = {
	   		println("Hello, wolrd !") } } )
		frame.add(panel)
	 	frame.setLocationrelativeTo(null)
	  	frame.setVisible(true)
	   		})
		}
	}

 ### Работа с базой данных
 Команды:
 * create database lab_5;
 * use lab_5;
 * create table stock(product varchar(15) primary key, price int(3), count_of_products int);
 * INSERT INTO stock (product, price, count_of_products) VALUES (banana,180,50);
 * select * from stock;

         insertButton.addActionListener(new ActionListener{
        override def actionPerformed(e: ActionEvent): Unit = {
          val url = "jdbc:mysql://localhost:3306/mysql"
          val username = "root"
          val password = "petia2010"

          Class.forName("org.gjt.mm.mysql.Driver")

          val connection = DriverManager.getConnection(url, username, password)

          try{
            val statement = connection.createStatement()
            val rs = statement.execute("INSERT INTO products VALUES ('" + productField.getText() + "'," + priceField.getText() + "," + countField.getText() + ")")
            productField.setText("")
            priceField.setText("")
            countField.setText("")
          }
          finally{
            connection.close()
          }
        }
      })

## Для работы с базой данных нужно с ней соедениться. Есть сама база данных, MySQL в нашем случае, номер порта localhost - это адрес компьютера, потом драйвер database-connector.jar. Реальное соединение просиходит во второй строке где Array -  указываем логин, пароль и имя.
Кроме сравнения непосредственно со значениями условия поиска могут содеожать специальный шаблон, то есть если наша строка удовлетворяет шаблону мы её выводим. Такое сравнение это LIKE по шаблону "%" это все символы, "_" - один символ:
	
 	select * from sclad where product LIKE '__cot'7;

Следующий оператор CONTAINS проверяет наличие заданной строки символов в любом месте искомой строки:

	select * from sclad CONTAINS(TITLE, 'I');

 Операторы:

 - BETWEEN (указывает из диапазона)
 - AND
 - OR

Оператор IN. Выводит значение соответсвующее определенному множеству:

	select * tovar from sclad where product IN ('carrot', 'apple', 'apricot');


### Агрегатные функции

* AVG - возвращает среднее значение поля для группы строк.
* COUNT -  подсчитывает количество строк, игнорируется значение NULL
* MIN
* MAX
* SUM

Можно использоать отдельно без всяких GROUP_BY, а можно использовать вместе с GROUP_BY.

* GROUP_BY - используется для группировани результирующего по не агрегатному столбцу
* HAVING
* ORDER_BY


## Вввод/вывод и работа с данными Лекция 09.11.2023
Apache Spark - это платформа распределеннных данных, которая позволяет обрабатывать большие объемы данных параллельно в кластере компьютеоров. Он предосталяеь унифицированный механизм для обработки рампреденных данных со втсроенными модулями  для Scala, Machine Learning, обработки графов, потоковой передачи. Первоначально Spark был разработан с использованием Scala, его интерфейсы доступны на Java, Python, R.

##### val rdd = sc.paralelize(Seq(1, 2, 3, 4, 5))
Spark Context - отвечает за устанновку и натсройку спарк.
Paralelize - метод который создает распределнную коллекцию данных RDD. В данном случае распараллеливает последоватлеьность 1 2 3 4 5, то есть получаетс, что Paralelize распаралеливает вычисления по разным узлам кластера.
Кластер Spark - это распределённая вычислительная среда которая состоит из нескоьких распределеенных узлов компьютеров объедененных в единую систему для выполнения вычислений с использованием Apache Spark. 

В кластере Spark узлы могут выполнять различные роли:

* Мастер узел 
* Рабочий узел

#### RDD (Resilient Distributed Dataset) – это простая, неизменяемая, распределенная коллекция объектов во фреймворке Apache Spark. RDD представляет собой распределенный набор данных, который делится на множество частей, обрабатывающихся различными узлами в кластере.

Функция агрегат вычисляет результат на разных частях коллекции, а затем объндиняет их.

	val listRDD = sc.parallelize(List(1, 2, 3, 4, 5))
	val flatmapFile = listRDD.map(x => x + 2)
	flatmapFile.foreach(println)

#### collect

	// Collect val data:Array[Int] = listRDD.collect() data.foreach(println)

Collect возвращает набор данных Array как массив 

##### count() - возвращает число элементов в наборе RDD каждый узел кластера подсчитывает количество элементов в своей локальной части данных. Результат суммируется.
##### countApprox() - возвращает приближенное число элементов в наборе, если время счета завершилось по таймауту, но не все элементы посчитаны. Применяется для BigData.
##### countApproxDistinct() - возвращает приближенное число рахличных элементов в наборе.

	printn("countApprox: " + listRDD.countApprox(1200))
	// Output: countApprox : (final: [7.000, 7.000])
	
	println("countApproxDistinct: " + listRDD.countApproxDistonct())
	// Output: countApproxDistinct : 5

### countByValue, countByValueApprox

countByValuе() - используется для подсчета количества вхождения каждого уникального значения в RDD. Позволяет найти количество вхождений каждого уникального элемента и представить результат в виде пары ключ-значение, где ключом является уникальное значение, а значением - количество вхождений. 

countByValueApprox() - используется для приближенного подсчета количества вхождений каждого уникального значения в RDD. Этот метод позволяет получить быстрый приближенный результат подсчета количества вхождений без полного сканирования всего набора данных. Коэффициент доверия, то есть 

	scala> val listRDD = sc.parallelize(List(1, 2, 3, 4, 5))
	listRDD: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[10]
	
	scala> println("countByValue : " + listRDD.countyByValue())
	countyByValue : Map(5 -> 1, 1 -> 2, 2 -> 2, 3 -> 2, 4 -> 1)

 
	
	scala> val counts = listRDD.countByValueApprox(1000, 0.9)
	counts: org.apache.spark.partial.PartialResult[scala.collection.Map[Int, org.apache.spark.partial.BoundedDouble]] = 1: Map(5 -> [1,000, 1,000], 1 -> [2,000, 2,000], 2 -> [2,000, 2,000], 3 -> [2,000, 2,000], 4 -> [1,000, 1,000]))




	val listRDD = sc.parallelize(List(1, 2, 3, 4, 5))
	def param0 = (accu:Int, v:Int) => accu + v
	def param1 = (accu1:Int, accu2:Int) => accu1 + accu2
	print;n("aggregate: " + listRDD.aggregate(0)(param0, param1))	

#### first
first() - возвращает ервый элемент в наборе.
 
	 // first println("first: " + listRDD.first())

#### top
top() - возвращает первые n элементов в наборе.
Note: Испоьзуйте этот метод только тогда, когда набор небольшой.

	// top println("top: " + lostRDD.top(2).mkString(","))
	// Output: take: 5,4

#### min
min() - возвращает минимальный элемент в наборе.
	
	// min println("min: " + listRDD.min())
	// Output: min: 1

#### max
max() - min() - возвращает максимальный элемент в наборе.
	
	// max println("max: " + listRDD.max())
	// Output: min: 5

### take, takeOrdered, takeSample

take() - возвращает первые num элементов в наборе.

takeOrdered() - возвращает  первые num наменьших элементов в наборе.

takeSample() - исползуется для выбора слчайных элементов из RDD.

	// take, takeOrdered, takeSample
	val listRDD = sc.parallelize(List(1, 2, 3, 4, 5))
	println("take: " + listRDD.take(2).mkString(","))
	// Output: take: 1, 2
	
	println("takeOrdered: " + listRDD.takeOrdered(2).mkString(","))
	// Output: takeOrdered: 1, 1
	 

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


## Лекция 23.11.2023

...

### Именная группа (NOUN PHRASE) 

Именная группа - это группа слов которые вместе обозначают и описывают человека, место, вещь. Состоит из существительного или местоимения, которое служит началом фразы, и любых сопутствующих модификаторов.

Несколько примеров словосочетаний с сущиствительными:

* The big, red apple
* His favorite book
* The city of New York
* An idea worth exploring

#### Пример кода opennlp

	//import java.sq;.{Connection, DriverManager, ResultSet}
	import java.io.FileInputStream
	import opennlp.tools.namefind.{NameFinderME, TokenNameFinderModel}
	import opennlp.tools.tokenize.*
	import opennlp.tools.util.Span
	
	object Main25 {
	    def main(args:Array[String]): Unit = {
	        val tokenizerModelIn = new FileInputStream("en-token.bin")
	        val tokenizerModel = new opennlp.tools.tokenize.TokenizerModel(tokenizerModelIn)
	        val tokenizer = new opennlp.tools.tokenize.TokenizerME(tokenizerModel)
	        // Load NER model
	        val nerModelIn = new FileInputStream("en-ner-person.bin")
	        val nerModel = new TokenNameFinderModel(nerModelIn)
	        val ner = new NameFinderME(nerModel)
	
	  		// Define some sample text
	        val text = "John Smith is a software engineer at Google."
	
	        // Tokenize the text
	        val tokens = tokenizer.tokenize(text)
	
	  		// Find the named entities in the text
	        val spans = ner.find(tokens)
	
	        // Print the named entities and their types
	        for(span <- spans) 
	        {
	            val entityType = span.getType
	            val entity = tokens.slice(span.getStart, span.getEnd).mkString("")
	            println(s"$entityType: $entity")
	        }
	    }
	}
		// The quick brown fox jumps over the lazy dog.,  The quick brown fox jumps, the lazy dog.

 ### Аналитические вычисления в Scala

Можно использовать следующие библиотеки:

 * Breeze
 * Spire
 * Apache Commons Math

 Бибилиотеки предоставляют широкий набор математических функций и операции для аналитических расчетов.  

#### Пример для задачи линейного программирования

	import org.apache.commons.math3.optim.linear._
	import org.apache.commons.math3.optim.linear.LinearConstraint
	import java.util.ArrayList
	import org.apache.commons.math3.optim.linear.Relationship
	import org.apache.commons.math3.optim.PointValuePair
	import org.apache.commons.math3.optim.nonlinear.scalar.GoalType
	
	object Main23 {
		def main(args:Array[String]):Unit = {
			// create a constraint: 2x + 3y <= 4
			val coeffs: Array[Double] = Array(2.0, 3.0)
			val coeffs2: Array[Double] = Array(1.0, 3.0) // задаются для целевой ф-ии
			val coeffs3: Array[Double] = Array(1.0, 2.0)
			val relationship: Relationship = Relationship.LEQ // задаёт отношения
			val value: Double = 4.0
			val coeffs1: Array[Double] = Array(-1.0, 3.0)
			val relationship2: Relationship = Relationship.GEQ
			val relationship3: Relationship = Relationship.GEQ
			val value2: Double = 1.0
			val value3: Double = 4.0
			val objectiveFunction = new LinearObjectiveFunction(coeffs2, 0.0)
			val constraint: LinearConstraint = new LinearConstraint(coeffs, relationship, value)
			val constraint2: LinearConstraint = new LinearConstraint(coeffs1, relationship2, value2)
			val constraint3: LinearConstraint = new LinearConstraint(coeffs3, relationship3, value3)
	
			// Solve the optimization
			val solver = new SimplexSolver() // симплекс-метод
	
			val constraintsList2: java.util.List[LinearConstraint] = new ArrayList[LinearConstraint]()
			constraintsList2.add(constraint)
			constraintsList2.add(constraint2)
			constraintsList2.add(constraint3)
			val result: PointValuePair = solver.optimize(objectiveFunction, new LinearConstraintSet(constraintsList2), GoalType.MINIMIZE)  // указывается целевая функция, 																		      //линейные ограничения, тип целевой 																	     // функции - направлена на минимум
	 		// Print the solution
			println(s"Minimum value: ${result.getValue}") // это результат целевой функции, в итоге выводит это в точке оптимума
			println(s"Solution: ${result.getPoint.mkString(",")}") // значения переменных в точке оптимума
			println("good")
		}
	}

Целевая функция имеет вид: 1x + 3y -> min. Ограничения: 2x + 3y <= 4, -x + 3y >= 1, x + 2y >= 4.


## Лекция 07.12.2023

...

#### Изменим прогрмму для выбора 1000 случайных пикселей и вычисления среднего значения и стандартного отклонения.

	import java.awt.image.BufferedImage
	import java.io.File
	import java.imageio.ImageIO
	import scala.util.Random
	import org.apache.commons.math3.stat.descriptive.{DescriptiveStatistics, SummaryStatistics}
	
	object Main25 {
		def main(args:Array[String]): Unit = {
	 		val imagePath = "one.jpg"
	   		// Load image using ImageIO
	     		val image: BufferedImage = ImageIO.read(new File(imagePath))
	
	       		// Get the width and height of the image  // Читаем картинку в массив пикселей, после этого случайными образом отбираем 1000 пикселей. 
		 	val width = image.getWidth 		 
	   		val heigth = image.getHeight
	
	     		// Get the array of pixels from the image
	       		val pixels = Array.ofDim[Int](width * height)
		 	image.getRGB(0, 0, width, height, pixels, 0, width)
	   		val count = 1000
	     		val numbers List[Double]() // Тут случайно выбранные пиксели хранятся в списке
	       		val random = new Random()
			for(i <- 0 until count) {
	  			var j = random.nextInt(width * height)
	     			numbers = math.abs(pixels(j)) :: numbers // Номера пикселей, пиксель j мы будем добавлять в список numbers
			}
	  		
     			val stats1 = new DescriptiveStatistics() // Находим здесь среднее значение и стандартное отклонение  и дальше выводим
	    		numbers.foreach(stats.addValue) 	// здесь среднее значение и стандартное отклонение 
	      		val mean = stats1.getMean()		//
			val stdDev = math.sqrt(stats1.getStandartDeviation()) //
	
	  		println(s"Mean value: ${mean}") //  и дальше 
	    		println(s"Stdev: ${stdDev}")   // выводим
	      }
	}


Ключевая идея - чтобы распознать картинку будем сравнивать её с другой картинкой из базы данных, здесь из файла. Сравниваем среднее значение и стандартное отклонение. Выбираем картинку по максимальному устройству - используем для этого косинусную метрику, если косинус близок к 0, то картинки схожи. Для того чтобы это сделать нужно запомнить номера случайно выбранных пикселей. 

### Ключевая идея

	import java.awt.image.BufferedImage
	import java.io.File	
	import java.imageio.ImageIO
	import scala.util.Random
	import org.apache.commons.math3.stat.descriptive.{DescriptiveStatistics, SummaryStatistics}
	
	object Main25 {
		def main(args:Array[String]): Unit = {
	 		val imagePath = "one.jpg"
	   		// Load the image using ImageIO
	
	       		var image: BufferedImage = ImageIO.read(new File(imagePath))
			// Get the width and height of image
	  		val width = image.getWidth
	    		val height = image.getHeight
	      		// Get the array of pixels from the image
			val pixels = Array.ofDim[Int](width * height)
	     		image getRGB(0, 0, width, height, pixels, 0, width)
	       		val count = 1000
		     	val numbers List[Double]()
		       	val random = new Random()
	
	  		for(i <- 0 until count) {
	    			var j = random.nextInt(width * height)
	       			nomers = j :: nomers
		  		numbers = math.abs(pixels(j)) :: numbers
	     		}
	  
	     		val stats1 = new DescriptiveStatistics()
	       		numbers.foreach(stats1.addValue)
		 	val mean = stats1.getMean()
	   		val stdDev = math.sqrt(stats1.getStandartDeviaton())
	     		println(s"Mean value: ${mean}")
	       		printn(s"Stdev: ${StdDev}")
			val imagePath = "two.jpg"
	   		var image2: BufferedImage = ImageIO.read(new File(imagePath))
	     		val pixels2 = Array.ofDim[Int](width * height)
	       		image2.getRGB(0, 0, width, height, pixels2, 0, width)
	
	  		var numbers2 = List[Double]()
	    		for (i <- 0 until count) {
	      			numbers2 = math.abs(pixels2(nomers(i))) :: numbers2
		 	}
	     		
	       		val stats2 = new DescriptiveSatistics()
	      		numbers2.foreach(stats2.addValue)
			val mean2 = stats.getMean()
			val stdDev2 = math.sqrt(stats2.getStandartDeviation())
	 		println(s"Mean-2 value: ${mean2}") //  и дальше 
			println(s"Stdev-2: ${stdDev2}")   // выводим
		}
	}

Косинусная метрикамежду двумя векторами $X$ и $Y$ вычисляется по формулe 

$\cos (X, Y)=\frac{\sum_i x_i y_i}{\sqrt{\sum_i x_i^2 \cdot \sum_i y_i^2}}$

Чем ближе косинус к "1", тем больше значение меры сходства между векторами.
$X1$ - среднее значение, $X2$ - стандартное отклонение для одной картинки. $Y1$ и $Y2$ - это для второй картинки. Если косинус раен 1 получается одна и та жа картинка.