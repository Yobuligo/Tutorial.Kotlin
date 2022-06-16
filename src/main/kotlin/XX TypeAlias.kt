/**
 * A typealias can be used to define a complex type which should be used at certain points
 * That makes it easy to change the type at a central point instead of adjusting all user
 */

typealias MyHashMap = HashMap<String, Int>

fun main() {
    val myHashMap: MyHashMap = hashMapOf(Pair("eins", 1))
}