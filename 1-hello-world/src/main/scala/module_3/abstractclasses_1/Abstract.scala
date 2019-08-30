package module_3.abstractclasses_1

/**
  * Abstract classes can contain members which are missing an implementation.
  * No instances of an abstract class can be created with the operator "new".
  */
abstract class IntSet {
  def contains(x: Int): Boolean
  def incl(x: Int): IntSet
}

object intsets {

  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4

}

// Set implementation using a binary search tree
class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def toString = "{" + left + elem + right + "}"
}

//TODO Do we really need multiple instances of Empty?
object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
}

//TODO What if the abstract class has methods with implementation?
abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3
}