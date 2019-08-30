package module_1.example_1

/**
  * The new recommended way to write a top-level application - scala v2.0.9
  */
object example1 extends App {
  println("Hello World")
}

/**
  * The old way :)
  */
object example2 {
  def main(args: Array[String]): Unit = {
    println("Hello World")
  }
}
