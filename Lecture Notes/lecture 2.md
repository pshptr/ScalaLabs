### 2 тема 
Существует несколько тем интегрированных сред разработки IDE поддерживающих разработку программ на скала Интелиж идея, Эклипс, ВС код,  Скала ИДЕ. Object  это считается как целый класс
Модули обычно используются в скала для и др глобальных обьектов 

Пример взаимодействия класов внутри модуля

 ```scala

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
 ```
---

В Scala конструкторы используются для создания экземпляров классов
Бывают два типа:
1) Первичные (основные)
2) Вспомогательные 

Первичный конструктор определяется, как часть определения класса и выполняется при создании экземпляра класса
Параметры основного конструктора определены в определении класса (Имя конструктора = имени класса)
 ```scala

    // Пример с первичным конструктором
    class MyClass(val name: String, val age: Int) {
      println("Creating instance of MyClass")
      def greet():Unit = println()
    
      // .....
    }
 ```

Вспомогательный конструктор могут иметь другие списки параметров, чем у основного. Определеются с помощью ключевого слова this, должны вызывать либо первичный конструктор, либо другой вспомогательный конструктор в качестве своего первого оператора
 ```scala
    // Пример со вспомогательным конструктором
    class MyClass(val name: String, val age: Int) {
      def this(name:String) = this(name, 0)
    
      println("Creating instance of MyClass")
      def greet():Unit = println(s"Hello, $name and $age years old")
    }
 ```

Вспомогательный конструктор вызывает основной конструктор с параметром name и значением по умолчанию (0)
 ```scala
    // Со вспомогательным конструктором
    
    object Main {
        def main(args: Array[String]):Unit = {
        val myObject2 = new MyClass("Jane")
        myObject2.greet() // print greet
      }
    }
 ```

Чтобы создать экземпляр класса с помощью вспомогательного конструктора можно использовать ключевое слово new за которым следует имя класса и параметры вспомогательного конструктора.

Пример чтения файлов и вывода его содержимого на консоль
 ```scala
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
 ```
    
 Функции и мтоды для работы со списками:
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
     ```scala
   
    def double(x: Int): Int = x * 2
    
    def main(args: Array[])
     ```
    
  ---
    
filter: функция фильтер отбирает элементы списка удовоетворяющие заданному условию
     ```scala
     
    filter 
    object Main22 {
    def isEven(x: int): Boolean = x
    
    reverse возвращает список в обратном порядке
    
    object Main51 {
    
    def main(args: Array[st
    
    foldLeft:
    
    Синтаксис следующий
    
    collection.foldLeft(initialValue)(binaryOperator)
	 ```

Функция поледовательно пр меняется к элементам списка слева направо накапливая результат
Collection эта коллекция над которой выполняется операция свёртки. initial value  это начальное значение аккумудятора или результата, бинарный оператор который обьеденяет каждый элемент коллекции и аккумулятор, работает с разными видами коллекций. 

пример суммы элементов списка:
 ```scala
	
	object Main22 {
	def main(args: Array[String]): Unit = {
	val myList
…
 ```
