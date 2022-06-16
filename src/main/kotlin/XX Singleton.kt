/**
 * In Kotlin you can have Singleton Instance classes without the need to create static singleton attributes etc.
 * Instead your can class can be declared as "object" instead of "class"
 * Anyway an instance of that class will be created and you can have instance attributes
 * The singleton-instance is addressed via its name
 */

interface ISingleton {
    fun getText(): String
}

object MySingleton : ISingleton {
    private val text: String = "MyText"

    override fun getText(): String {
        return text
    }
}

fun main(args: Array<String>) {
    println(MySingleton.getText())
    println(MySingleton.getText())
}