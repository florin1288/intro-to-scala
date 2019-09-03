package module_2.classes_3

/**
  * This definition of the class introduces 2 entities:
  * 1. A new type
  * 2. A constructor to create elements of this type
  */
class Rational(x: Int, y: Int) {

  def numerator = x
  def denominator = y

  def add(that:Rational) =
    new Rational(numerator * that.denominator + that.numerator * denominator, denominator * that.denominator)
  def neg: Rational = new Rational(-numerator, denominator)
  def sub(that: Rational) = add(that.neg)

  override def toString = numerator + "/" + denominator

}

object rationals extends App {

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  println(x.add(y))
  println(x.sub(y).sub(z))

  //TODO What rational number is being printed?
  println(y.add(y))

  //TODO How can we normalize it to its simplest form?
}

class Rational2(x: Int, y: Int) {

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)

  def numerator = x / g
  def denominator = y / g

  def add(that:Rational2) =
    new Rational2(numerator * that.denominator + that.numerator * denominator, denominator * that.denominator)

  def less(that: Rational2) =
    numerator * that.denominator < that.numerator * denominator

  //Write a function that returns the maximum of 2 rational numbers - by using the "less" method
  //TODO def max(that: Rational) = if () ... else ...

  override def toString = numerator + "/" + denominator

}

object rationals2 extends App {

  val x = new Rational2(1, 3)
  val y = new Rational2(5, 7)
  val z = new Rational2(3, 2)

  println(y.add(y))
  println(x.less(y))
//  println(x.max(y))

  //TODO What happens if we define an invalid rational number?
  val invalid = new Rational2(1, 0)
  invalid.add(invalid)

}

/**
  * A class implicitly introduces a constructor - primary constructor:
  * 1. takes the parameters of the class
  * 2. executes all statements in the class body
  */
class Rational3(x: Int, y: Int) {
  // Enforce a precondition on the caller of the function
  require(y != 0, "denominator must be nonzero")

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)

  println(g)

  //TODO What if we want to define another constructor?
  def this(x: Int) = this(x, 1)

}
