object Main22 {


  def main(args: Array[String]): Unit = {
    val myList = List(1, 2, 3, 4, 5)
    val sum = myList.foldLeft(0)((ac_c, x) => ac_c + x)
    println(sum) // Output: 15


  }
}
