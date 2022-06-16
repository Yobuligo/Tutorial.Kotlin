/**
 * Infix are methods without the need to write a dot
 * They are used to providing more readability
 */

class Condition(private val value: String) {
    infix fun equals(value: String): Boolean {
        return true
    }
}

fun main(args: Array<String>) {
    val condition = Condition("Test")

    //reading infix methods feels more naturale more like using keywords
    if (condition equals "Test") {
    }
}