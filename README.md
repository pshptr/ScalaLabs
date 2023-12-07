# ScalaLabs
---
## Лабораторные работы по дисциплине "ф-прог" (Функциональное программирование) Scala 3, 3 курс 5 семестр БГУИР КСиС ВМСиС 2023. Конспект лекций ниже, после лабораторных работ.
#### Мною выполнялись следующие лабораторные работы по варинатам соответственно: лр 1 вар 3, лр 2 вар 2, лр 3 вар 1, лр 4 вар 1, лаб 5 вар общий.

 ---

 ## Конспект лекций:

 #### (если берёте конспект, то не забывайте пожалуйста ставить звёздочки ⭐)

* [lecture 1](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%201.md)
* [lecture 2](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%202.md)
* [lecture 3 zip](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%203%20zip.md)
* [lecture 4 string](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%204%20string.md)
* [lecture 5 lazy val](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%205%20lazy%20val.md)
* [lecture 6 string builder](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%206%20string%20builder.md)
* [lecture 7 regular expressions](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%207%20regular%20expressions.md)
* [lecture 8 02.11.2023](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%208%2002.11.2023.md)
* [lecture 9 09.11.2023](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%209%2009.11.2023.md)
* [lecture 10 nlp 16.11.2023](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%2010%20nlp%2016.11.2023.md)
* [lecture 11 commons math 23.11.2023](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%2011%20commons%20math%2023.11.2023.md)
* [lecture 12 07.12.2023](https://github.com/pshptr/ScalaLabs/blob/master/Lecture%20Notes/lecture%2012%2007.12.2023.md)

---

 ### [Лабораторная работа 1. Создание простых S-проектов на основе классов](https://github.com/pshptr/ScalaLabs/blob/master/src/main/scala/Lab1.scala)

#### Вариант 1. 
 Построить генератор случайных чисел по следующей схеме. Вводите 10-значное число  с клавиатуры. Формируете два новых целых числа A и B: 
 первое  A состоит из первых пяти цифр, второе B  – из последних  цифр введенного числа, начиная с шестой.    
 Перемножаете числа A и B друг на друга. Первые три цифры результата С, будучи поделенными на 1000, дают первое случайное число REZ.  
 Чтобы сформировать следующее случайное число, прибавляете к Z число  С и повторяете процесс. Формируете два новых целых числа A и B: 
 первое  A состоит из первых пяти цифр, второе B  – из последних  цифр числа Z, начиная с шестой.    
 Перемножаете числа A и B друг на друга. Первые три цифры результата С, будучи поделенными на 1000, дают второе случайное число.  
 Чтобы сформировать следующее случайное число, прибавляете к Z число  С и повторяете процесс. Сформируйте 5 случайных чисел.
Если z отрицателен, то это значит, что надо заменить первую цифру единицы на ноль и убрать знак “минус”, кроме того,
нужно поддерживать длину строки не меньше 10 символов. Сказанное, демонстрируется следующим примером:
   
    object Main234 {
      def main(args: Array[String]): Unit = {
       print("Enter the number: ")
   
     var numberString =""
     var a =0
     var b=0
     var c=0
     var rez: Float =0.0
     var z=0
     numberString = scala.io.StdIn.readLine()
      if ( (numberString.length() <= 10)) {
       println("Incorrect number");
       sys.exit(0)  }
      for (i <- 1 to 10) {
      a = numberString.substring(0, 5).toInt
      //println(numberString.length()); 
      b=  numberString.substring(5, 10).toInt
      c= a*b
      rez=c.toString().substring(0,3).toFloat / 1000
      z+=c 
      println(a);
      println(b);
      println(c);
      println(rez); 
      println("z="+ z)
      numberString= numberString.substring(1,numberString.length()-1)
      numberString="011"+z 
       } 
      } 
    }

#### Вариант 2. 
Использовать предыдущий пример, но только число А получается из цифр, стоящих на четных позициях, а В-на нечетных.

    def substringFromSymbolsAtEvenPositions(str: String): String = {
      val result = new StringBuilder
      for (i <- str.indices if i % 2 == 1) {
        result.append(str(i))
      }
      result.toString()
    }
    
     object Main234 {
      def main(args: Array[String]): Unit = {
        val originalString = "1234567890"
        val substring = substringFromSymbolsAtEvenPositions(originalString)
        println(substring)
    }
    }
    // Сформируйте по этой схеме 5 случайных чисел.
            
#### Вариант 3. 
Построить генератор случайных чисел по следующей схеме. Вводите 10-значное число Z с клавиатуры. Формируете два новых целых числа A и B: 
первое  A состоит из первых пяти цифр, второе B  – из последних  цифр числа Z, начиная с шестой.   
Дописываете к числу В число А. Получаете число W. Находите С= Z*W. Первые три цифры результата С, будучи поделенными на 1000, дают первое случайное число REZ.  
Чтобы сформировать следующее случайное число, формируете два новых целых числа A и B: первое  A состоит из первых пяти цифр, второе B  – из последних  цифр числа C,
начиная с шестой.    Дописываете к числу В число А. Получаете число W. Находите C= C*W. Первые три цифры результата C, будучи поделенными на 1000, 
дают второе случайное число REZ. 
Сформируйте 3 случайных чисел по этой схеме.

#### Вариант 4.       
Построить генератор случайных чисел по следующей схеме. Вводите 16-значное число Z с клавиатуры. Формируете два новых целых числа A и B: 
первое  A состоит из первых восьми цифр, второе B  – из последних  цифр числа Z, начиная с девятой.    
Перемножаете числа A и B друг на друга, получаем число С. Первые три цифры результата С, будучи поделенными на 1000, дают первое случайное число REZ. 
Чтобы сформировать следующее случайное число, умножаете Z  на число  С  и оставляете 16 цифр в результате. Повторяете процесс для сформированного таким образом числа Z. 
Формируете два новых целых числа A и B: первое  A состоит из первых восьми цифр, второе B  – из последних  цифр числа Z, начиная с девятой.    
Перемножаете числа A и B друг на друга. Первые три цифры результата С, будучи поделенными на 1000, дают второе случайное число. 
Чтобы сформировать следующее случайное число, умножаете  Z  на число  С и повторяете процесс. Сформируйте 5 случайных чисел.

---

### [Лабораторная работа 2. Работа со списками и функциями](https://github.com/pshptr/ScalaLabs/blob/master/src/main/scala/Lab2.scala)

#### Вариант 1. 
1. Написать функцию для подсчета суммы элементов списка, значение которых не превосходит 10. Список задать самостоятельно.
2. Написать функцию для подсчета суммы первых трех элементов списка из 10 элементов. Список задать самостоятельно.
3. Написать функцию для отыскания (минимального) индекса максимального элемента списка. Список задать самостоятельно.
4. Написать функцию для проверки того, что список упорядочен по возрастанию. Список задать самостоятельно.
5. Написать функцию для проверки наличия одинаковых элементов в списке. Список задать самостоятельно. Функция возвращает значение Да или Нет

#### Вариант 2. 
1. Написать функцию для подсчета суммы отрицательных элементов списка. Список задать самостоятельно.
2. Написать функцию для подсчета суммы последних трех элементов списка из 10 элементов. Список задать самостоятельно.
3. Написать функцию для отыскания  индексов всех максимальных элементов списка. Список задать самостоятельно.
4. Написать функцию для проверки того, что список не упорядочен  ни по возрастанию, ни по убыванию. Список задать самостоятельно.
5. Написать функцию для проверки наличия  трех одинаковых элементов в списке. Список задать самостоятельно. Функция возвращает значение такого элемента.
           
#### Вариант 3. 
1. Написать функцию для подсчета суммы элементов списка, значение которых лежит в диапазоне [0,5]. Список задать самостоятельно.
2. Написать функцию для подсчета суммы элементов списка с номерами, содержащимися в другом списке. Список задать самостоятельно.
3. Написать функцию для отыскания индекса минимального элемента списка. Список задать самостоятельно.
4. Написать функцию для проверки того, что элементы списка не превосходят заданной величины. Список задать самостоятельно.
5. Написать функцию для подсчета числа  элементов списка, которые не превосходят заданной величины. Список задать самостоятельно.

#### Вариант 4.     
1. Написать функцию для подсчета суммы элементов списка, значение которых по модулю не превосходит 5. Список задать самостоятельно.
2. Написать функцию для подсчета суммы каждого второго элемента списка из 10 элементов. Список задать самостоятельно.
3. Написать функцию для отыскания  индекса элемента списка, наименее отклоняющегося от среднего значения по списку. Список задать самостоятельно.
4. Написать функцию для проверки того, что список содержит квадрат одного из своих элементов. Список задать самостоятельно.
5. Написать функцию для проверки наличия трех разных элементов в списке. Список задать самостоятельно. Функция возвращает значение Да или Нет

---

### [Лабораторная работа 3. Работа со строками](https://github.com/pshptr/ScalaLabs/blob/master/src/main/scala/Lab3.scala)

#### Вариант 1. 
1. Дан текст: ‘Hello to everybody’. C помощью техники регулярных выражений заменить латинские буквы на русские (или на цифры, если русский шрифт не поддерживается)
2. Найти в тексте “When executing the exercise extract all extra words” все слова, начинающиеся на ext.
2. В тексте ‘A big round ball fall to the ground’  заменить артикль the на a.
3. Записать все слова в тексте в обратном порядке.
4. Дан текст: ‘Hello to everybody’. Выбросить все гласные.
5. Дан текст: ‘Hello to everybody’. Удвоить каждую букву в слове
6. Дан текст: ‘Hello to everybody’. Удалить все вхождения буквы y
7. Дан текст: ‘Hello to everybody’. Вставить слова with heartness чтобы получить
8. Hello with heartness  to everybody

#### Вариант 2. 
1. Дан текст: ‘1+1=2’. C помощью техники регулярных выражений заменить цифры на слова: 1- one, 2 - two
2. Найти в тексте ‘Being quiet buetiful girl she never thought of buety’ все слова, начинающиеся на bue.
3. В тексте ‘one plus one is something’  заменить one на two.
4. Поменять местами первое и последнее слово в тексте  world is nice.
5. Дан текст: ‘Hello to all my friends’. Выбросить все согласные.
6. Дан текст: ‘Hello to everybody’. Удалить каждую вторую букву в слове
7. Дан текст: ‘Hello to everybody’. Удалить все вхождения буквы e
8. Дан текст: ‘Be healthy’. Вставить слова always чтобы получить Be always healthy

            
#### Вариант 3. 
1. Дан текст: ‘Passport AB-123-456’. C помощью техники регулярных выражений  найти числа в этом тексте
2. Найти в тексте ‘Being strong means nothing’ все слова, заканчивающиеся на ing.
3. В тексте ‘123+723=846’  заменить 3 на 4, 6 – на 8.
4. Записать все слова в тексте в случайном порядке. Текст: big dreadful dog runs after small poor cat. Всех слов 8. Номера 1,2,3, …,8. 
5. Заменить слово с номером 1 на слово с номером 7, слово с номером 2 на слово с номером 6, слово с номером 4 на слово с номером 5. 
Замена обоюдная, то есть слова просто меняются местами.
6. Дан текст: ‘Hello to everybody’. Выбросить каждую третью букву.
7. Дан текст: ‘Hello to everybody’. Удвоить каждую букву в слове
8. Дан текст: ‘Hello to everybody’. Удалить все вхождения буквы o
9. Дан текст: ‘Hello to everybody Katty, Mikky’. Вывести все слова, начинающиеся с заглавной буквы.


#### Вариант 4. 
1. Дан текст: ‘Passport AB-123-436’. C помощью техники регулярных выражений найти число вхождений цифры 3.
2. Дан текст: ‘Passport AB-123-436’. C помощью техники регулярных выражений найти сумму всех цифр в тексте.
3. В тексте ‘123+723=846’  выделить все символы арифметических операций.
4. Записать все слова в тексте в случайном порядке. Текст: big black cat runs after small poor catty. Всех слов 8. Номера 1,2,3, …,8. 
5. Заменить слово с номером 1 на слово с номером 4, слово с номером 2 на слово с номером 7, слово с номером 3 на слово с номером 6. 
Замена обоюдная, то есть слова просто меняются местами.
6. Дан текст: ‘Hello to Ronny old nail’. Найти удвоенные вхождения согласных.
7. Дан текст: ‘Hello to Ronny old nail’. Найти число слов, записанных с большой буквы.
8. Дан текст: ‘Hello to everybody’. Подсчитать число всех вхождений буквы o
9. Дан текст: ‘Hello agaiN to everybody Katty, Mikky’. Вывести все слова, начинающиеся со строчной буквы.

---

### [Лабораторная работа 4. Работа с пакетом SPARK](https://github.com/pshptr/ScalaLabs/blob/master/src/main/scala/Lab4.scala)



#### Вариант 1. 
1. Создать собственный текстовый файл на английском или немецком языке – 4-5 предложений.
2. Вывести все слова из текстового файла, исключая stop-слова
3. Вывести все слова, содержащие букву t
4. Вывести все слова, заканчивающиеся на ing
5. Вывести все слова вторая буква которых а
6. Вывести все слова, последняя буква которых s
7. Вывести каждое второе слово

#### Вариант 2. 
1. Создать собственный текстовый файл на английском или немецком языке – 4-5 предложений. Тема - программирование
2. Вывести все слова из текстового файла, исключая stop-слова
3. Вывести все слова, содержащие вхождение prog
4. Вывести все слова, заканчивающиеся на ion
5. Вывести все слова третья буква которых r
6. Вывести все слова, содержащие как минимум две буквы e
7. Вывести последнее слово
            
#### Вариант 3. 
1. Создать собственный текстовый файл на английском или немецком языке – 4-5 предложений. Тема - спорт
2. Вывести все слова из текстового файла, исключая stop-слова
3. Вывести все слова, содержащие вхождение ball или sport
4. Вывести все слова, заканчивающиеся на ion
5. Вывести все слова третья буква которых c
6. Вывести все слова, длина которых больше 4
7. Вывести предпоследнее слово

#### Вариант 4.         
1. Создать собственный текстовый файл на английском или немецком языке – 4-5 предложений. Тема - авто
2. Вывести все слова из текстового файла, исключая stop-слова
3. Вывести все слова, содержащие вхождение car или avto
4. Вывести все слова, заканчивающиеся на my
5. Вывести все слова третья буква которых d
6. Вывести все слова, у которых три и более гласных
7. Вывести второе слово

### Доп задания: 
1-е задание: написать 2 предложения на английском языке и удалить оттуда все пробелы между словами через регулярные выражения двумя разными способами.
________________________________________________________________________________________

	val sentences = Seq("This is the first sentence.", "Here is the second sentence.")
	val sentenceRDD = spark.sparkContext.parallelize(sentences)
	
	val sentenceWithoutSpaces1 = sentenceRDD.map(sentence => sentence.replaceAll(" ", ""))
	sentenceWithoutSpaces1.collect().foreach(println)
	
	val sentenceWithoutSpaces2 = sentenceRDD.map(sentence => sentence.split(" ").mkString(""))
	sentenceWithoutSpaces2.collect().foreach(println)

________________________________________________________________________________________

	val sentences = Seq("This is the first sentence.", "Here is the second sentence.")
	val sentenceRDD = spark.sparkContext.parallelize(sentences)
	
	val sentencesWithoutSpaces = sentenceRDD.map(sentence => sentence.replaceAll("\\s", ""))
	sentencesWithoutSpaces.collect().foreach(println)

________________________________________________________________________________________

2-е задание: в слове mother утроить букву t.
________________________________________________________________________________________

	val word = "mother"
	val wordWithTripleT = word.replace("t", "ttt")
	println(wordWithTripleT)

3-e задание: удалить все гласные во всех словах из двух английских предложений из 1-го задания.
________________________________________________________________________________________

	val sentences = Seq("This is the first sentence.", "Here is the second sentence.")
	val sentenceRDD = spark.sparkContext.parallelize(sentences)
	
	val vowels = "aeiouAEIOU"
	val wordsWithoutVowels = sentenceRDD.flatMap(sentence => {
	  val words = sentence.split(" ")
	  words.map(word => word.replaceAll(s"[$vowels]", ""))
	})
	wordsWithoutVowels.collect().foreach(println)
____________________________________________________________________________________

---

### [Лабораторная работа 5. Работа с базой данных](https://github.com/pshptr/ScalaLabs/blob/master/src/main/scala/Lab5.scala)

	import java.awt.event.{ActionEvent, ActionListener}
	import javax.swing.{JButton, JFrame, JPanel, SwingUtilities}
	
	object  ButtonModule {
	  def main(args: Array[String]): Unit = {
	    SwingUtilities.invokeLater(() => {
	      val frame = new JFrame("My Application")
	      frame.setSize(300, 200)
	      frame.setLocationRelativeTo(null)
	      val panel = new JPanel()
	      val button = new JButton("Click me!")
	      panel.add(button)
	
	      button.addActionListener(new ActionListener {
	        override def actionPerformed(e: ActionEvent): Unit = {
	          println("Hello, world!")
	        }
	      })
	
	      frame.add(panel)
	      frame.setVisible(true)
	    })
	  }
	}

 Наше  приложение таково
	
	import java.awt.event.{ActionEvent, ActionListener}
	import javax.swing.{JButton, JFrame, JPanel, SwingUtilities}
	import java.awt.Dimension
	import javax.swing.{JFrame, JLabel,JTextField, JPanel, SwingUtilities}
	import java.sql.{Connection, DriverManager, ResultSet}
	import java.awt.Color
	
	object ButtonModule  {
	   val frame = new JFrame("My Application")
	  frame.setSize(800, 600)
	  frame.setLayout(null)
	  
	  def main(args: Array[String]): Unit = {
	       SwingUtilities.invokeLater(() => {
      
     // val panel = new JPanel()
      val label1=new JLabel("Title")
      val label2=new JLabel("Price")
      label1.setBounds(50,120,100,20)
      label2.setBounds(200,120,70,20)
      val button1 = new JButton("Insert")
      val button2 = new JButton("Select")
      val textField = new JTextField(20)
      val textField2 = new JTextField(20)
      button1.setBounds(20,80,120,20)
      button2.setBounds(150,80,250,20)
      textField.setBounds(20,150,130,20)
      textField2.setBounds(160,150,130,20)
      frame.add(button1)
      frame.add(button2)
      frame.add(label1)
      frame.add(textField)
      frame.add(label2)
      frame.add(textField2)
      
      button1.addActionListener(new ActionListener {
        override def actionPerformed(e: ActionEvent): Unit = {
          val url = "jdbc:mysql://localhost:3306/mydb"
    val username = "root"
    val password = "1"
          Class.forName("com.mysql.jdbc.Driver")
      // Class.forName("org.gjt.mm.mysql.Driver")

          val conn = DriverManager.getConnection(url, username, password)
   
          try {
           val stmt = conn.createStatement()
        val rs = stmt.execute("INSERT INTO sclad VALUES ('" + textField.getText + "'," + textField2.getText + ")")
          
         
           textField2.setText("")
           
          textField.setText("Added record")
         }
          finally {
            conn.close()
                 }

          
          
       //   textField.setText("problems")
        }
      })
        
      
      
      button2.addActionListener(new ActionListener {
        override def actionPerformed(e: ActionEvent): Unit = {
          ////////
          {
    val url = "jdbc:mysql://localhost:3306/mydb"
    val username = "root"
    val password = "1"

    Class.forName("com.mysql.jdbc.Driver")
    val conn = DriverManager.getConnection(url, username, password)

    try {
       val stmt = conn.createStatement()
       val prod_name= textField.getText().toString().trim()
       val rs = stmt.executeQuery("SELECT * FROM sclad WHERE product = '"+prod_name+"'")
       while (rs.next()) {
         
         val name = rs.getString("product")
         val price = rs.getInt("price")
        // println(s"name=$name, price=$price")
         textField2.setText(""+price)
         }
       } finally {
    conn.close()
                 }
}
    
          ///////
          
          
       //   textField.setText("Hello World, You say")
        }
      })

    
      frame.setBackground(Color.BLUE)
      frame.setLocationRelativeTo(null)
      frame.setVisible(true)
      
      })
  }
}
Разберитесь с этим приложением.

#### Вариант Общий.
1. Расширить количество столбцов таблицы sclad, добавив поле количество товара на складе.
2. Вывести товар, дающий максимальную прибыль (количество*цену).
3. Выбрать товар по ограничению (не меньше такой-то величины).

---
