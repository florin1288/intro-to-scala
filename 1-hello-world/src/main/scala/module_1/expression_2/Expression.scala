package module_1.expression_2

/**
  * The 'if' statement is changing the state of the 'result' variable.
  */
class statements(marks: Int) {
  var result = ""
  if (marks >= 50)
    result = "passed"
  else
    result = "failed"
  println("Your results just came in, you " + result + ".")
}

/**
  * The state of the 'result' cannot change.
  */
class expressions(marks: Int) {
  val result = if (marks >= 50) "passed" else "failed"
  println("Your results just came in, you " + result + ".")
}

object evaluation extends App {

  //TODO What happens when we pass expressions as function parameters?
  def square(x: Double): Double = x * x
  def sumOfSquares(x: Double, y: Double): Double = square(x) + square(y)

  // We first evaluate all function arguments going from left to right.
  // We then replace the formal parameters of the function with the actual arguments.
  println(sumOfSquares(1, 2))
  println(sumOfSquares(1 + 2, 1 * 2))
  println(sumOfSquares(square(1 + 2), square(1 * 2)))

}





