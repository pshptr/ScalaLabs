## лекция 02.11.2023
### Использование текстовых полей 
  ```scala

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
  ```

 Меню создаётся в 3 этапа: сначала полосу bar, затем размещаем на полосе пункты меню, затем в каждом пункте menu создаём опции, они называются menu item. 

 Создание простого меню в окне (фрейме)
   ```scala

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
   ```

 ### Работа с базой данных
 Команды:
 * create database lab_5;
 * use lab_5;
 * create table stock(product varchar(15) primary key, price int(3), count_of_products int);
 * INSERT INTO stock (product, price, count_of_products) VALUES (banana,180,50);
 * select * from stock;

 ```scala

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
  ```

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
  ```scala

	val listRDD = sc.parallelize(List(1, 2, 3, 4, 5))
	val flatmapFile = listRDD.map(x => x + 2)
	flatmapFile.foreach(println)
  ```

#### collect

	// Collect val data:Array[Int] = listRDD.collect() data.foreach(println)

Collect возвращает набор данных Array как массив 

##### count() - возвращает число элементов в наборе RDD каждый узел кластера подсчитывает количество элементов в своей локальной части данных. Результат суммируется.
##### countApprox() - возвращает приближенное число элементов в наборе, если время счета завершилось по таймауту, но не все элементы посчитаны. Применяется для BigData.
##### countApproxDistinct() - возвращает приближенное число рахличных элементов в наборе.
  ```scala

	printn("countApprox: " + listRDD.countApprox(1200))
	// Output: countApprox : (final: [7.000, 7.000])
	
	println("countApproxDistinct: " + listRDD.countApproxDistonct())
	// Output: countApproxDistinct : 5
  ```

### countByValue, countByValueApprox

countByValuе() - используется для подсчета количества вхождения каждого уникального значения в RDD. Позволяет найти количество вхождений каждого уникального элемента и представить результат в виде пары ключ-значение, где ключом является уникальное значение, а значением - количество вхождений. 

countByValueApprox() - используется для приближенного подсчета количества вхождений каждого уникального значения в RDD. Этот метод позволяет получить быстрый приближенный результат подсчета количества вхождений без полного сканирования всего набора данных. Коэффициент доверия, то есть 
  ```scala

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
  ```

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
  ```scala

	// take, takeOrdered, takeSample
	val listRDD = sc.parallelize(List(1, 2, 3, 4, 5))
	println("take: " + listRDD.take(2).mkString(","))
	// Output: take: 1, 2
	
	println("takeOrdered: " + listRDD.takeOrdered(2).mkString(","))
	// Output: takeOrdered: 1, 1
  ```
