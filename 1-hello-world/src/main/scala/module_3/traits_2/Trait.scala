package module_3.traits_2

/**
  * In Scala, as well as in Java, a class can only have one superclass!
  * But what if a class has several natural supertypes to which it conforms or from which it wants to inherit code?
  */
trait Planar {
  def height: Int
  def width: Int
  def surface = height * width
}

trait Shape

trait Movable

/**
  * Classes, objects and traits can inherit from at most one class but arbitrary many traits.
  */
abstract class Square extends Shape with Planar with Movable

/**
  * Type Hierarchy
  *
  * Any - the base of all types
  *     - methods defined: '==', '!=', 'equals', 'hashCode', 'toString'
  *
  * AnyRef - the base of all reference types
  *        - alias of 'java.lang.Object'
  *
  * AnyVal - the base of all primitive types
  *
  * Null - the subtype of every reference type
  *      - incompatible with subtypes of AnyVal
  *
  * Nothing - the bottom of Scala's type hierarchy
  *         - there is no value of type Nothing
  *         - used to signal abnormal termination - i.e. throw Exception
  *         - used as an element type of empty collection - i.e. Set[Nothing]
  *
  */

object types extends App {

  def error(msg: String): Nothing = throw new Error(msg)

  val x = null
  println(getType(x))

  val y: String = null
  println(getType(y))

  //TODO val z: Int = null
  //TODO println(getType(z))


  import scala.reflect.ClassTag
  def getType[T](v: T)(implicit ev: ClassTag[T]) = ev.toString

}
