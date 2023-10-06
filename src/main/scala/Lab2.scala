object Main122 { // foldLeft


  def main(args: Array[String]): Unit = {
    val myList = List(1, 2, 3, 4, 5)
    val sum = myList.foldLeft(0)((ac_c, x) => ac_c + x)
    println(sum) // Output: 15


  }
}

object Main123 { // zip
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

object Main124 { // head and tail
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


object Main {
  def sumOfNegatives(list: List[Int]): Int = { // Эта функция рекурсивно суммирует отрицательные элементы в списке.
    // Рекурсия происходит на строках, где вызывается sumOfNegatives(tail),
    // где tail - это оставшаяся часть списка. Рекурсия продолжается,
    // пока не будет достигнут базовый случай, когда список Nil (пустой).

    if (list.isEmpty) {
      0
    } else if (list.head < 0) {
      list.head + sumOfNegatives(list.tail)
    } else {
      sumOfNegatives(list.tail)
    }


    //    list match {
    //      case Nil => 0
    //      case head :: tail if head < 0 => head + sumOfNegatives(tail)
    //      case _ :: tail => sumOfNegatives(tail)
    //    }
  }

  def sumOfLastThree(list: List[Int]): Int = { // не рекурс // Эта функция рекурсивно суммирует последние три
    // элемента списка. Рекурсия также происходит на строках,
    //  где вызывается sumOfLastThree(tail), где tail - это оставшаяся
    //  часть списка. Базовый случай достигается, когда длина списка
    //  меньше или равна 3.
    if (list.isEmpty) {
      0
    } else if (list.length <= 3) {
      list.sum
    } else {
      sumOfLastThree(list.tail)
    }

    //    list match {
    //      case Nil => 0
    //      case _ if list.length <= 3 => list.sum
    //      case _ :: tail => sumOfLastThree(tail)
    //    }
  }

  def indexiesOfMax(list: List[Int]): List[Int] = {
    def loop(list: List[Int], max: Int, index: Int, indices: List[Int]): List[Int] = {
      list match {
        case Nil => indices
        case head :: tail if head > max => loop(tail, head, index + 1, List(index))
        case head :: tail if head == max => loop(tail, max, index + 1, indices :+ index)
        case _ :: tail => loop(tail, max, index + 1, indices)
      }
    }

    list match {
      case Nil => Nil
      case head :: tail => loop(tail, head, 1, List(0))
    }
  }

  def isUnordered(list: List[Int]): Boolean = {
    def isUnorderedRec(list: List[Int], ascending: Boolean): Boolean = {
      list match {
        case Nil => true
        case _ :: Nil => true
        case head1 :: head2 :: tail =>
          if ((head1 < head2 && ascending) || (head1 > head2 && !ascending))
            isUnorderedRec(tail, ascending)
          else
            false
      }
    }

    isUnorderedRec(list, ascending = true) && isUnorderedRec(list, ascending = false)
  }

  def hasThreeEqual(list: List[Int]): Option[Int] = {
    def countOccurrences(element: Int, lst: List[Int]): Int = {
      lst match {
        case Nil => 0
        case head :: tail if head == element => 1 + countOccurrences(element, tail)
        case _ :: tail => countOccurrences(element, tail)
      }
    }

    list.find { element => countOccurrences(element, list) >= 3 }
  }

  def main(args: Array[String]): Unit = {
    val list1 = List(-1, 2, -3, 4, -5)
    val list2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("Sum of negatives: " + sumOfNegatives(list1)) // Sum of negatives: -9
    println("Sum of last three: " + sumOfLastThree(list2)) // Sum of last three: 27
    println("Indexies of max: " + indexiesOfMax(list1)) // Indexies of max: List(3)
    println("Is unordered: " + isUnordered(list1)) // Is unordered: true

    val list3 = List(1, 2, 3, 3, 4, 5, 6, 7, 8, 3, 9, 10)
    println("Has three equal: " + hasThreeEqual(list3)) // Has three equal: Some(3)

    val list4 = List(1, 3, 4, 4, 5)
    println("Has three equal: " + hasThreeEqual(list4)) // Has three equal: None
  }
}


