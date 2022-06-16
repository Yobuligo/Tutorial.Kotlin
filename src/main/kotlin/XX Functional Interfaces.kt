/**
 * Functional interfaces are interfaces which must have exactly one function
 * If a parameter is of type of a functional interface a lamda can be injected instead
 */

fun interface ITextProvider {
    fun getText(): String
}

class TextProvider : ITextProvider {
    override fun getText(): String {
        return "Using a default class implementation of a functional interface"
    }
}

class TextPrinter {
    fun printText(textProvider: ITextProvider) {
        println(textProvider.getText())
    }
}

fun getText(): ITextProvider = object : ITextProvider {
    override fun getText(): String {
        return "Test"
    }
}

fun main(args: Array<String>) {
    // Using a default class implementation of a functional interface
    TextPrinter().printText(TextProvider())

    // Implementing the functional interface inline
    TextPrinter().printText(object : ITextProvider {
        override fun getText(): String {
            return "Using the functional interface by overriding it inline"
        }
    })

    // Using function
    TextPrinter().printText(getText())

    // Using a lambda as functional interface implementation
    TextPrinter().printText { "Using a lambda as functional interface implementation" }


    // New in 1.6.20 implement in a variable
    val textProvider = ITextProvider { "My Text" }
    TextPrinter().printText(textProvider)

}