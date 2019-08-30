package module_4.patternmatching_4

/**
  * A case class is like a regular class with a few key differences, one being that it is a good option for
  * modeling immutable data.
  */
trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr

/**
  * When we define case classes, Scala implicitly defines companion objects with apply methods.
  */
object Number {
  def apply(n: Int): Number = new Number(n)
}

object Sum {
  def apply(e1: Expr, e2: Expr): Sum = new Sum(e1, e2)
}

/**
  * Pattern matching in Scala is a generalization of the "switch case" statement from Java to class hierarchies.
  */
object patternmatching extends App{

  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
    case _ => throw new Error("Unknown expression " + e)
  }

}

/**
  * It is also possible to define the evaluation function directly in the base trait.
  *
  * How is this better?
  * It's up to your design:
  *   - are you more often creating new subclasses? - Object Oriented decomposition is better
  *   - are you more often creating new methods? - Pattern Matching is advantageous
  *
  */
trait Expr1 {
  def eval: Int = this match {
    case Number1(n) => n
    case Sum1(e1, e2) => e1.eval + e2.eval
  }
}
case class Number1(n: Int) extends Expr1
case class Sum1(e1: Expr1, e2: Expr1) extends Expr1

//TODO How would the "show" function look like?
trait Expr2 {
  def show: String = this match {
    case Number2(n) => n.toString
    case Sum2(e1, e2) => e1.show + " + " + e2.show
  }
  def eval: Int = this match {
    case Number2(n) => n
    case Sum2(e1, e2) => e1.eval + e2.eval
  }
}
case class Number2(n: Int) extends Expr2
case class Sum2(e1: Expr2, e2: Expr2) extends Expr2