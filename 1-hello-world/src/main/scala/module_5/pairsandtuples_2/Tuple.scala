package module_5.pairsandtuples_2

/**
  * A tuple type (T1,...,Tn) is an abbreviation of the parameterized type scala.Tuplen[T1,...,Tn]
  *
  * This is how a tuple of 2 elements is defined in Scala:
  *
  *   case class Tuple2[T1, T2](_1: +T1, _2: +T2) {
  *     override def toString = "(" + _1 + "," + _2 + ")"
  *   }
  *
  * The fields of a tuple can be accessed with names: _1, _2, ...
  *
  */
object tupleoperations extends App {

  val nums = 3 :: 2 :: -1 :: 4 :: Nil

  //TODO Let's implement the merge sort algorithm
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (first, second) = xs splitAt n
      merge(msort(first), msort(second))
    }
  }

  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

  print(msort(nums))

}
