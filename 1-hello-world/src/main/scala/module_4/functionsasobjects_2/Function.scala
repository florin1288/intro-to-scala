package module_4.functionsasobjects_2

/**
  * In Scala function values are treated as objects.
  *
  * The function type: A => B is just an abbreviation for the class scala.Function1[A, B] defined as:
  *
  * package scala
  * trait Function1[A, B] {
  *   def apply(x: A): B
  * }
  *
  * There are also traits Function2, Function3 ...
  */
object functionsasobjects extends App {

  //TODO What would this anonymous function expand to?
  (x: Int) => x * x

  {
    class AnonFun extends Function1[Int, Int] {
      def apply(x: Int) = x * x
    }
    new AnonFun
  }

  //TODO A shorter way to write it - 'anonymous class syntax'?
  new Function1[Int, Int] {
    def apply(x: Int) = x * x
  }

}

object functioncalls extends App {

  val f = (x: Int) => x * x

  //TODO What would be the Object Oriented translation of this function call?
  f(7)

  //TODO val f1 = ...

}

