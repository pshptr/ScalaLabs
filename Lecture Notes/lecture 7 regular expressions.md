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