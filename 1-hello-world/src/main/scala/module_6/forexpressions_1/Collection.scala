package module_6.forexpressions_1

/**
  * In imperative languages, the 'for' loops generate side effects.
  * In functional programming, the 'for-expressions' produce new results.
  *
  * A for-expression is of the form:
  *   for ( s ) yield e
  *
  *   where s - a sequence of generators ( p <- e ) and filters ( if f )
  *         e - an expression whose value is returned by an iterator
  *
  */

/*
 * Given a positive integer n, find all pairs of positive integers i and j, with 1 <= j < i < n ,
 * such that i + j is prime.
 *
 */
object pairsofprime extends App {

  def isPrime(n: Int) = (2 until n) forall (n % _ != 0)

  val n = 7

  //TODO Let's generate pairs
  ((1 until n) map (i =>
    (1 until i) map (j => (i, j)))).flatten

  //TODO Is there a way to combine map and flatten?
  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j)))

  //TODO Let's apply the isPrime filter
  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))

  //TODO Can we make it more concise and easier to understand?
  for {

    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)

  } yield (i, j)

}

/*
 * The N-Queens problem is to place N queens on a chessboard so that no queen is threatened by another:
 *  - there can't be two queens in the same row, column or diagonal
 *
 */
object nqueens extends App {

  def queens(n: Int): Set[List[Int]] = {

    def placeQueens(k: Int): Set[List[Int]] =
      if(k == 0) Set(List())
      else
        for {

          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)

        } yield col :: queens

    placeQueens(n)
  }

  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val queensWithRow = (row - 1 to 0 by -1) zip queens
    queensWithRow forall {
      case (r, c) => col != c && math.abs(col - c) != row - r
    }
  }

  def show(queens: List[Int]): String = {
    val lines =
      for (col <- queens.reverse)
        yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    "\n" + (lines mkString "\n")
  }

  println((queens(4) map show) mkString "\n")

}