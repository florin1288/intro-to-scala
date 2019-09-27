package module_6.maps_2

/**
  * Another fundamental collection type is the map.
  * A map of type Map[Key, Value] is a data structure that associates keys of type Key with
  * values of type Value.
  *
  * Maps are Iterables:
  *   - class Map[Key, Value] extends the collection type Iterable[(Key, Value)]
  *
  * Maps are Functions:
  *   - class Map[Key, Value] extends the function type Key => Value, so maps can be used everywhere
  *   functions can.
  *
  */
object mapoperations extends App {

  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)

  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")

  //TODO How can we handle this exception?
  capitalOfCountry("Andorra")

  capitalOfCountry get "Andorra"

}
