package module_5.implicitparameters_3

/**
  * When a function takes an implicit parameter of type T, the following rules apply:
  *
  *   - The compiler will search for an implicit definition that:
  *     -- is marked 'implicit'
  *     -- has a type compatible with T
  *     -- is visible at the point of the function call, or if defined in a companion object associated with T
  *
  *   - If there is a single (most specific) definition, it will be taken as actual argument for the implicit parameter
  *
  *   - Otherwise it's an error
  */
object implicitparameters extends App {

  val nums = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")

  import scala.math.Ordering

  //TODO Let's implement a generalized merge sort
  def msort[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(ord), msort(snd)(ord))
    }
  }

  println(msort(nums)(Ordering.Int))
  println(msort(fruits)(Ordering.String))

  //TODO Can we avoid passing around the 'ord' value?
  def msort1[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort1(fst), msort1(snd))
    }
  }

  println(msort1(nums))
  println(msort1(fruits))

}
