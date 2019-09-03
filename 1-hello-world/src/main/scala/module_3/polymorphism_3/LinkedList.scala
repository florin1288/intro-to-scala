package module_3.polymorphism_3

import java.util.NoSuchElementException

/**
  * A linked list is a fundamental data structure in many functional languages.
  * It consists of:
  *   - Nil - the empty list
  *   - Cons - a cell containing an element and a reference to the remainder of the list
  */
trait IList
class INil extends IList
class ICons(val head: Int, val tail: IList) extends IList

//TODO What is the 'val' parameter list translated into?
class IntCons1(_head: Int, _tail: IList) extends IList {
  val head = _head
  val tail = _tail
}

//TODO Can we make the linked list more generic?
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = false
  //TODO  What types are 'head' and 'tail'?
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}

//TODO No definition of 'head' and 'tail' methods?
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

/**
  * Not only classes can have type parameters
  */
object singleton extends App {
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

  singleton[Int](1)
  singleton(2)

  singleton[Boolean](true)
  singleton(false)
}

//TODO Write a function that takes an integer n and a list and select the n-th element of the list.
object nth extends App {

  def nth[T](n: Int, xs: List[T]): T =
    if (n == 0) xs.head
    else nth(n - 1, xs.tail)

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
  println(nth(2, list))

  //TODO What happens for: nth(-1, list), nth(5, list)?
}

//TODO Make the 'nth' function throw IndexOutOfBoundsException if index is out of range
object nth1 extends App {

  def nth[T](n: Int, xs: List[T]): T =
    //TODO if () throw new IndexOutOfBoundsException
    if (n == 0) xs.head
    else nth(n - 1, xs.tail)

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
  println(nth(-1, list))
  println(nth(5, list))

}
