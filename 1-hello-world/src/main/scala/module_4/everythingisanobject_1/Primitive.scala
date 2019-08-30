package module_4.everythingisanobject_1

/**
  * Scala - pure object oriented language?
  * What about primitives and functions?
  *
  * Types such as Int or Boolean do not receive special treatment in Scala.
  * They are like any other classes, defined in the package 'scala'.
  */

/**
  * The Boolean type maps internally to the JVM's primitive type boolean for efficiency reasons.
  * But we could define it as a class.
  */
abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean): Boolean = ifThenElse(x, _false)
  def || (x: => Boolean): Boolean = ifThenElse(_true, x)
  def unary_! : Boolean = ifThenElse(_false, _true)
}

object _true extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = t
}

object _false extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = e
}
