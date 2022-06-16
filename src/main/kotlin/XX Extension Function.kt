/**
 * An extension function is a function that can extend an existing class
 * even though the class is not in my scope
 * For example it is possible to add a function to the class String
 * The extension is global. This means it is everywhere available.
 *
 * After adding an extension function it is available for all instances of the class where the extension was added
 */

/**
 * This extension function extends the class String.
 * The name has "String." as prefix which gives the class that should be extended followed by the name
 * It is a normal function which can have parameters and a return value
 */
fun String.myExtensionFunction(parameter: Int): Int {
    return parameter
}

fun main() {
    val helloWorld = "Hello World"
    println(helloWorld.myExtensionFunction(123))
}