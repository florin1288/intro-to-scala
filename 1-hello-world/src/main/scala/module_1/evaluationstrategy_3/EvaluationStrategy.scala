package module_1.evaluationstrategy_3

/**
  * Call-by-value - it evaluates every function argument only once
  * Call-by-name - the function argument is not evaluated if the corresponding parameter is unused in the evaluation
  * of the function body
 */
object evaluationStrategy extends App {

  def loop: Int = loop
  def constOne(x: Int, y: => Int) = 1

  println(constOne(1 + 2, loop))
  println(constOne(loop, 1 + 2))

}

/**
  * def - is the form of "by-name", its right-hand side is evaluated on each use
  * val - is the form of "by-value", its right-hand side is evaluated at the point of the definition itself
  */
object valueDefinition extends App {

  def square(x: Double): Double = x * x
  def loop: Int = loop

  val x = 2
  val y = square(2)

  def x1: Int = loop
  println("def x1")

  val y1: Int = loop
  println("val y1")
}

/**
  * Implement the 'and' and 'or' functions such that (without using && or || operators):
  *   and(x, y) that implements x && y
  *   or(x, y) that implements x || y
  *
  * NOTE: Keep in mind non-terminating arguments!
  */
object condition extends App {

  //TODO  def and(x: , y: ): Boolean = if()  else

  //TODO  def or(x: , y: ): Boolean = if()  else

}

/**
  * A block in Scala is also an expression.
  */
object scope extends App {

  val x = 0
  def f(y: Int): Int = y + 1
  val result = {
    val x = f(3)
    x * x
  } + x

  //TODO What is the value of result?
  println(result)
}

