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



