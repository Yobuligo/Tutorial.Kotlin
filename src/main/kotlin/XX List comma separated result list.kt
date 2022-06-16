/**
 * In case a comma separated string should be created from e.g. a stringList
 * the function [joinToString] can be used
 */

fun main() {
    val myList = listOf("one", "two", "three")
    println(myList.joinToString(","))
}