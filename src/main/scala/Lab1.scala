import scala.io.StdIn

object Main22 { // foldLeft


  def main(args: Array[String]): Unit = {
    val myList = List(1, 2, 3, 4, 5)
    val sum = myList.foldLeft(0)((ac_c, x) => ac_c + x)
    println(sum) // Output: 15


  }
}

object Main23 { // zip
  def main(args: Array[String]): Unit = {
    val a = List(1, 2, 3)
    val b = List("one", "two", "three")
    val zipped = a.zip(b) // List((1, "one"), (2, "two"), (3, "three"))
    println(zipped)
    val filteredList = zipped.filter { case (a, _) => a == 1 }
    println(filteredList)
    val tup=filteredList.head
    println(tup)
    val secondItem = tup._2
    println(secondItem)
  }

}

object Main24 { // head and tail
//  def sumList(lst: List[Int]): Int = {
//    if (lst.isEmpty) 0
//    else lst.head*lst.head + sumList(lst.tail)
//  }
val numbers = List(1, 2, 3, 4, 5)
//  val first = numbers.head // 1
//  val rest = numbers.tail // List(2, 3, 4, 5)
val reversed = numbers.reverse // List(5, 4, 3, 2, 1)



  def main(args: Array[String]): Unit = {
    val myList = List(1, 2, 3, 4, 5)
//    val sumw = sumList(myList)
//    println(numbers.head)
//    println(numbers.tail
    println(numbers.reverse)
  }
}




class RandomNumberGenerator {
  private def generate_A_and_B(z: Long): (Int, Int) = {
    val a = (z / 100000).toInt // A - первые пять цифр
    val b = (z % 100000).toInt // B - последние пять цифр
    (a, b)
  }

  private def calculateW(a: Int, b: Int): Int = {
    a * 100000 + b
  }

  private def calculateREZ(c: Long): Int = {
    ((c / 1000) % 1000).toInt
  }

  def generateRandomNumbers(z: Long, iterations: Int): List[Int] = {
    var c = z
    var rezList = List.empty[Int]

    for (_ <- 1 to iterations) {
      val (a, b) = generate_A_and_B(c)
      val w = calculateW(a, b)
      c = c * w
      var rez = calculateREZ(c)

      if (rez < 0) {
        rez = rez * -1
      }

      rezList :+= rez
    }

    rezList
  }

}

object RandomNumberGeneratorApp {
  def main(args: Array[String]): Unit = {
    println("Введите 10-значное число Z:")
    val z = StdIn.readLine().toLong

    val generator = new RandomNumberGenerator()
    val randomNumbers = generator.generateRandomNumbers(z, 3)

    println("Сгенерированные случайные числа:")
    randomNumbers.foreach(println)
  }
}




