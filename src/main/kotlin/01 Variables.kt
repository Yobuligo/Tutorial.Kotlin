/**
 * !!!! Variablen sind immer Objekte und keine skalaren Typen mehr
 * Im Buch steht, dass beim gegenseitigen Zuweisen von Variablen auf das gleiche Objekt verwiesen wird
 * das müsste im Umkehrschluss bedeuten, dass wenn ich den Wert einer Variablen ändere, auch die andere verändert wird
 * Ist aber nicht so. Wahrscheinlich ein Fehler im Buch
 *
 * Kotlin is completely written in Kotlin.
 * So you can e.g. navigate forward to the Basic Types Int, String etc.
 * You only will see normal classes.
 */

fun main(args: Array<String>) {
    var x = 5
    var y = x
    x = 7
    println("x = $x and y = $y")
}