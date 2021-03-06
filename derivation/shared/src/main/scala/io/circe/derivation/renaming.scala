package io.circe.derivation

package object renaming {
  final val snakeCase: String => String = _.replaceAll(
    "([A-Z]+)([A-Z][a-z])",
    "$1_$2"
  ).replaceAll("([a-z\\d])([A-Z])", "$1_$2").toLowerCase

  final def replaceWith(pairs: (String, String)*): String => String =
    original => pairs.toMap.getOrElse(original, original)
}
