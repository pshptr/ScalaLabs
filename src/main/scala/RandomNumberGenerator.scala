import scala.io.StdIn

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
