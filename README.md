# ScalaLabs
Лабораторные работы по предмету ф-прог (Функциональное программирование) Scala 3, 3 курс 5 семестр БГУИР КСиС ВМСиС 2023.

Мною выполнялись следующие лаборвторные работы по варинатам соответственно: лр 1 вар 3, лр 2 вар 2, лр 3 вар 1



Лабораторная работа 1:

Вариант 1. 
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

Вариант 2. 
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
Сформируйте по этой схеме 5 случайных чисел.
            
Вариант 3. 
Построить генератор случайных чисел по следующей схеме. Вводите 10-значное число Z с клавиатуры. Формируете два новых целых числа A и B: 
первое  A состоит из первых пяти цифр, второе B  – из последних  цифр числа Z, начиная с шестой.   
Дописываете к числу В число А. Получаете число W. Находите С= Z*W. Первые три цифры результата С, будучи поделенными на 1000, дают первое случайное число REZ.  
Чтобы сформировать следующее случайное число, формируете два новых целых числа A и B: первое  A состоит из первых пяти цифр, второе B  – из последних  цифр числа C,
начиная с шестой.    Дописываете к числу В число А. Получаете число W. Находите C= C*W. Первые три цифры результата C, будучи поделенными на 1000, 
дают второе случайное число REZ. 
Сформируйте 3 случайных чисел по этой схеме.

Вариант 4.       
Построить генератор случайных чисел по следующей схеме. Вводите 16-значное число Z с клавиатуры. Формируете два новых целых числа A и B: 
первое  A состоит из первых восьми цифр, второе B  – из последних  цифр числа Z, начиная с девятой.    
Перемножаете числа A и B друг на друга, получаем число С. Первые три цифры результата С, будучи поделенными на 1000, дают первое случайное число REZ. 
Чтобы сформировать следующее случайное число, умножаете Z  на число  С  и оставляете 16 цифр в результате. Повторяете процесс для сформированного таким образом числа Z. 
Формируете два новых целых числа A и B: первое  A состоит из первых восьми цифр, второе B  – из последних  цифр числа Z, начиная с девятой.    
Перемножаете числа A и B друг на друга. Первые три цифры результата С, будучи поделенными на 1000, дают второе случайное число. 
Чтобы сформировать следующее случайное число, умножаете  Z  на число  С и повторяете процесс. Сформируйте 5 случайных чисел.



Лабораторная работа 2:

Вариант 1. 
Написать функцию для подсчета суммы элементов списка, значение которых не превосходит 10. Список задать самостоятельно.
Написать функцию для подсчета суммы первых трех элементов списка из 10 элементов. Список задать самостоятельно.
Написать функцию для отыскания (минимального) индекса максимального элемента списка. Список задать самостоятельно.
Написать функцию для проверки того, что список упорядочен по возрастанию. Список задать самостоятельно.
Написать функцию для проверки наличия одинаковых элементов в списке. Список задать самостоятельно. Функция возвращает значение Да или Нет

Вариант 2. 
Написать функцию для подсчета суммы отрицательных элементов списка. Список задать самостоятельно.
Написать функцию для подсчета суммы последних трех элементов списка из 10 элементов. Список задать самостоятельно.
Написать функцию для отыскания  индексов всех максимальных элементов списка. Список задать самостоятельно.
Написать функцию для проверки того, что список не упорядочен  ни по возрастанию, ни по убыванию. Список задать самостоятельно.
Написать функцию для проверки наличия  трех одинаковых элементов в списке. Список задать самостоятельно. Функция возвращает значение такого элемента.
           
Вариант 3. 
Написать функцию для подсчета суммы элементов списка, значение которых лежит в диапазоне [0,5]. Список задать самостоятельно.
Написать функцию для подсчета суммы элементов списка с номерами, содержащимися в другом списке. Список задать самостоятельно.
Написать функцию для отыскания индекса минимального элемента списка. Список задать самостоятельно.
Написать функцию для проверки того, что элементы списка не превосходят заданной величины. Список задать самостоятельно.
Написать функцию для подсчета числа  элементов списка, которые не превосходят заданной величины. Список задать самостоятельно.

Вариант 4.     
Написать функцию для подсчета суммы элементов списка, значение которых по модулю не превосходит 5. Список задать самостоятельно.
Написать функцию для подсчета суммы каждого второго элемента списка из 10 элементов. Список задать самостоятельно.
Написать функцию для отыскания  индекса элемента списка, наименее отклоняющегося от среднего значения по списку. Список задать самостоятельно.
Написать функцию для проверки того, что список содержит квадрат одного из своих элементов. Список задать самостоятельно.
Написать функцию для проверки наличия трех разных элементов в списке. Список задать самостоятельно. Функция возвращает значение Да или Нет



Лабораторная работа 3:

Вариант 1. 
Дан текст: ‘Hello to everybody’. C помощью техники регулярных выражений заменить латинские буквы на русские (или на цифры, если русский шрифт не поддерживается)
Найти в тексте “When executing the exercise extract all extra words” все слова, начинающиеся на ext.
В тексте ‘A big round ball fall to the ground’  заменить артикль the на a.
Записать все слова в тексте в обратном порядке.
Дан текст: ‘Hello to everybody’. Выбросить все гласные.
Дан текст: ‘Hello to everybody’. Удвоить каждую букву в слове
Дан текст: ‘Hello to everybody’. Удалить все вхождения буквы y
Дан текст: ‘Hello to everybody’. Вставить слова with heartness чтобы получить
Hello with heartness  to everybody

Вариант 2. 
Дан текст: ‘1+1=2’. C помощью техники регулярных выражений заменить цифры на слова: 1- one, 2 - two
Найти в тексте ‘Being quiet buetiful girl she never thought of buety’ все слова, начинающиеся на bue.
В тексте ‘one plus one is something’  заменить one на two.
Поменять местами первое и последнее слово в тексте  world is nice.
Дан текст: ‘Hello to all my friends’. Выбросить все согласные.
Дан текст: ‘Hello to everybody’. Удалить каждую вторую букву в слове
Дан текст: ‘Hello to everybody’. Удалить все вхождения буквы e
Дан текст: ‘Be healthy’. Вставить слова always чтобы получить
Be always healthy

            
Вариант 3. 
Дан текст: ‘Passport AB-123-456’. C помощью техники регулярных выражений  найти числа в этом тексте
Найти в тексте ‘Being strong means nothing’ все слова, заканчивающиеся на ing.
В тексте ‘123+723=846’  заменить 3 на 4, 6 – на 8.
Записать все слова в тексте в случайном порядке. Текст: big dreadful dog runs after small poor cat. Всех слов 8. Номера 1,2,3, …,8. 
Заменить слово с номером 1 на слово с номером 7, слово с номером 2 на слово с номером 6, слово с номером 4 на слово с номером 5. 
Замена обоюдная, то есть слова просто меняются местами.
Дан текст: ‘Hello to everybody’. Выбросить каждую третью букву.
Дан текст: ‘Hello to everybody’. Удвоить каждую букву в слове
Дан текст: ‘Hello to everybody’. Удалить все вхождения буквы o
Дан текст: ‘Hello to everybody Katty, Mikky’. Вывести все слова, начинающиеся с заглавной буквы.


Вариант 4. 
Дан текст: ‘Passport AB-123-436’. C помощью техники регулярных выражений найти число вхождений цифры 3.
Дан текст: ‘Passport AB-123-436’. C помощью техники регулярных выражений найти сумму всех цифр в тексте.
В тексте ‘123+723=846’  выделить все символы арифметических операций.
Записать все слова в тексте в случайном порядке. Текст: big black cat runs after small poor catty. Всех слов 8. Номера 1,2,3, …,8. 
Заменить слово с номером 1 на слово с номером 4, слово с номером 2 на слово с номером 7, слово с номером 3 на слово с номером 6. 
Замена обоюдная, то есть слова просто меняются местами.
Дан текст: ‘Hello to Ronny old nail’. Найти удвоенные вхождения согласных.
Дан текст: ‘Hello to Ronny old nail’. Найти число слов, записанных с большой буквы.
Дан текст: ‘Hello to everybody’. Подсчитать число всех вхождений буквы o
Дан текст: ‘Hello agaiN to everybody Katty, Mikky’. Вывести все слова, начинающиеся со строчной буквы.