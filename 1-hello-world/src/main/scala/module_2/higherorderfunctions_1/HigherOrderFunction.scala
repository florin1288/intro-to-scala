package module_2.higherorderfunctions_1

/**
  * In Scala, functions are treated as first-class values.
  *
  * Higher order functions - functions that take other functions as parameters, or whose result is a function.
  */
object function extends App {

  def cube(i: Int): Int = i * i * i
  def fact(i: Int): Int = if (i == 0) 1 else i * fact(i - 1)


  //TODO Can you find the common pattern?

  // Compute the sum of the integers between a and b
  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b)

  // Compute the sum of the cubes of all integers between a and b
  def sumCubes(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

  // Compute the sum of the factorials of all integers between a and b
  def sumFactorials(a: Int, b: Int): Int =
    if (a > b) 0 else fact(a) + sumFactorials(a + 1, b)

}

object higherOrderFunction extends App {

  def id(i: Int): Int = i
  def cube(i: Int): Int = i * i * i
  def fact(i: Int): Int = if (i == 0) 1 else i * fact(i - 1)


  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)

  //TODO def sumCubes(a: Int, b: Int): Int = ...
  //TODO def sumFactorials(a: Int, b: Int): Int = ...
  //TODO def sumInts(a: Int, b: Int): Int = ...

}
