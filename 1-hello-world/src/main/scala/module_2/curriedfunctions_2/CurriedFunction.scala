package module_2.curriedfunctions_2

/**
  * Currying is the technique of translating the evaluation of a function that takes multiple arguments into
  * evaluating a sequence of functions, each with a single argument.
  */
object function extends App {

  def id(i: Int): Int = i
  def cube(i: Int): Int = i * i * i
  def fact(i: Int): Int = if (i == 0) 1 else i * fact(i - 1)


  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)

  //TODO Can we get rid of the repetition?
  def sumInts(a: Int, b: Int): Int = sum(id, a, b)
  def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)
  def sumFactorials(a: Int, b: Int): Int = sum(fact, a, b)

}

object curriedFunction extends App {

  def id(i: Int): Int = i
  def cube(i: Int): Int = i * i * i
  def fact(i: Int): Int = if (i == 0) 1 else i * fact(i - 1)


  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }

  //TODO def sumInts =
  //TODO def sumCubes =
  //TODO def sumFactorials =

}

object curriedFunction2 extends App {

  def condition: Boolean = true
  def cube(i: Int): Int = i * i * i


  //TODO A shorter way of writing it
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)

  //TODO Remember the initial definition?
  def sumI(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumI(f, a + 1, b)

  //TODO What we gained?
  val myGenerator = SumOfCubesGenerator(sum(cube))
  val result = if (condition) myGenerator.getSumOfCubesFrom1To3 else myGenerator.getSumOfCubesFrom3To5

}

case class SumOfCubesGenerator(f: (Int, Int) => Int) {
  def getSumOfCubesFrom1To3 = f(1, 3)
  def getSumOfCubesFrom3To5 = f(3, 5)
}

object curriedFunction3 extends App {

  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)

  // Compute the product of the values of a function for the points on a given interval
  //TODO def product(f: Int => Int)(a: Int, b: Int): Int =

  // Write factorial in terms of the product function
  //TODO def fact(n): Int =

  // Write a more general function, that generalizes both sum and product functions
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, unit: Int)(a: Int, b: Int): Int =
    if (a > b) unit else combine(f(a), mapReduce(f, combine, unit)(a + 1, b))

  //TODO def product(f: Int => Int)(a: Int, b: Int): Int =
  //TODO def sum(f: Int => Int)(a: Int, b: Int): Int =

}