/**
 * Vararg (Variable Number of Arguments)
 * is a keyword that can be set before of a parameter.
 * This means that a variable number of elements can be handed over to that parameter.
 * The values are separated by ,
 * Often this is e.g. used for programs, that can be called with different parameter constellations
 *
 * To inject that variable over several function calls the spread operator * has to be used.
 */

class DemoVararg {
    fun setTableKeyNamesAndPrint(vararg keyName: String) {
        //use the spread operator * to inject the vararg KeyNames to function print
        //The spread operator creates a list of all keyName elements and hands it over to function print
        print(*keyName)
    }

    private fun print(vararg keyName: String) {
        keyName.forEach { key -> println(key) }
    }
}

fun main(args: Array<String>) {
    val demoVararg = DemoVararg()
    demoVararg.setTableKeyNamesAndPrint("first", "second", "third")
    println()
    demoVararg.setTableKeyNamesAndPrint("first", "second", "third", "forth", "fifth")
}