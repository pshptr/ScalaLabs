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