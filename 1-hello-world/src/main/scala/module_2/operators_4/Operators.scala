package module_2.operators_4

class Rational(x: Int, y: Int) {

  def numerator = x
  def denominator = y

  def less(that: Rational) =
    numerator * that.denominator < that.numerator * denominator

  def max(that: Rational) = if (this.less(that)) that else this

  def add(that: Rational) =
    new Rational(numerator * that.denominator + that.numerator * denominator, denominator * that.denominator)

}

object operators extends App {

  val x = 2
  val y = 3

  val xr = new Rational(1, 2)
  val yr = new Rational(2, 3)

  //TODO Even if a Rational number is a natural number as an Integer, there is a difference at user level.
  x + y
  xr.add(yr)

  //TODO Can we eliminate this difference?

  // 1. Any method with only one parameter can be used like an infix operator
  xr add yr

  // 2. We can define our own operators
  val xr2 = new Rational2(1, 2)
  val yr2 = new Rational2(2, 3)
  xr2 + yr2

}

class Rational2(x: Int, y: Int) {

  def numerator = x
  def denominator = y

  def < (that: Rational2) =
    numerator * that.denominator < that.numerator * denominator

  def max(that: Rational2) = if (this < that) that else this

  def + (that: Rational2) =
    new Rational2(numerator * that.denominator + that.numerator * denominator, denominator * that.denominator)

}
