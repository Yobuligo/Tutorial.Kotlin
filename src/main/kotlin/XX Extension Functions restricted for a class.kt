/**
 * Next to global there is a possibility to provide an extension function for an object only in specific classes
 */

/**
 * Define a class and an extension function for a class
 */
class ClassWithExtensionFunction {
    fun String.myExtensionFunctionOnThisClass() {
        println("Extension function exists only on that class")
    }

    fun test(anyString: String) {
        //String.myExtensionFunctionOnThisClass is only available within that class
        println(anyString.myExtensionFunctionOnThisClass())
    }
}

fun main() {
    val helloWorld = "Hello World"
    //String.myExtensionFunctionOnThisClass isn't available here
}