package module_4.decomposition_3

/**
  * Decomposition is an important problem in programming.
  * Let's say there is a hierarchy of classes. How do we minimize the static dependencies between them,
  * so that the program doesn't become too complex and tedious to maintain.
  *
  * Scenario:
  * Expressions can be represented as a class hierarchy, with a base trait Expr and two subclasses, Number and Sum.
  */
trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
}

class Number(n: Int) extends Expr {
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def numValue: Int = n
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOp")
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}

// We can now write an evaluation function
object classhierarchy extends App {

  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression " + e)
  }

}

//TODO What happens if at some point you need to add a new expression like the Product?
trait Expr1 {
  def isNumber: Boolean
  def isSum: Boolean

  //TODO: new method added
  def isProd: Boolean

  def numValue: Int
  def leftOp: Expr1
  def rightOp: Expr1
}

class Prod(e1: Expr1, e2: Expr1) extends Expr1 {
  def isNumber: Boolean = false
  def isSum: Boolean = false

  def isProd: Boolean = true

  def numValue: Int = throw new Error("Prod.numValue")
  def leftOp: Expr1 = e1
  def rightOp: Expr1 = e2
}

class Number1(n: Int) extends Expr1 {
  def isNumber: Boolean = true
  def isSum: Boolean = false

  //TODO: new method added
  def isProd: Boolean = false

  def numValue: Int = n
  def leftOp: Expr1 = throw new Error("Number.leftOp")
  def rightOp: Expr1 = throw new Error("Number.rightOp")
}

class Sum1(e1: Expr1, e2: Expr1) extends Expr1 {
  def isNumber: Boolean = false
  def isSum: Boolean = true

  //TODO: new method added
  def isProd: Boolean = false

  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr1 = e1
  def rightOp: Expr1 = e2
}

//TODO Solution 1: Use type tests and type casts - Prone to runtime errors - Unsafe and highly discouraged
object classhierarchy1 extends App {

  def eval(e: Expr1): Int = {
    if (e.isInstanceOf[Number1]) e.asInstanceOf[Number1].numValue
    else if (e.isInstanceOf[Sum1]) eval(e.asInstanceOf[Sum1].leftOp) + eval(e.asInstanceOf[Sum1].rightOp)
    else throw new Error("Unknown expression " + e)
  }

}

//TODO Solution 2: Use Object Oriented decomposition - better solution
//TODO But what happens if we need to display the expressions now? - define new methods in all subclasses
trait Expr2 {
  def eval: Int

  //TODO Add new method to display the expression
  def show: String
}

class Number2(n: Int) extends Expr2 {
  def eval: Int = n

  //TODO: new method added
  def show: String = n.toString
}

class Sum2(e1: Expr2, e2: Expr2) extends Expr2 {
  def eval: Int = e1.eval + e2.eval

  //TODO: new method added
  def show: String = e1.show + " + " + e2.show
}
