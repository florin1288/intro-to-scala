package module_5.lists_1

/**
  * List - is a fundamental data structure in functional programming
  *
  * There are 2 important differences between lists and arrays:
  *   - lists are immutable - the elements of a list cannot be changed
  *   - lists are recursive, while arrays are flat
  *   - like arrays, lists are homogeneous - the elements must all have the same type
  */

object listoperations extends App {

  val fruit = List("apples", "oranges", "pears")
  val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))

  val fruit1 = "apples" :: "oranges" :: "pears" :: Nil
  val nums = 1 :: 2 :: 3 :: 4 :: Nil

  //TODO Let's implement the insertion sort
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  //TODO Let's implement the function 'last' - retrieves the last element in a list
  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case _ :: ys => last(ys)
  }

  //TODO Let's implement the function 'init' - retrieves a list containing all the elements excepting the last one
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(_) => List()
    case y :: ys => y :: init(ys)
  }

  //TODO Let's implement the function 'concat' - retrieves a list as the result of concatenating 2 lists
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  //TODO Let's implement the function 'reverse' - retrieves a list containing all the initial elements in reverse order
  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case y :: ys => reverse(ys) ++ List(y) ::: List(y)
  }

}
