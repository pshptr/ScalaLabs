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