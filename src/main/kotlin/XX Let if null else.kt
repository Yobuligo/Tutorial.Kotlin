/**
 * In case it is required to write code which needs to check of a value is null else like:
 * if (x != null){
 *      println("not null")
 * }else{
 *      println("null)
 * }
 *
 * It is possible to use let instead. Let is a function which is available on each object instance
 */

interface IPrinter {
    fun print(text: String? = null)
}

class PrinterOld : IPrinter {
    override fun print(text: String?) {
        if (text != null) {
            println("text is not null")
        } else {
            println("text is null")
        }
    }
}

class PrinterNew : IPrinter {
    override fun print(text: String?) {
        text?.let { println("text is not null") } ?: println("text is null")
    }
}

fun main() {
    PrinterOld().print()
    PrinterOld().print("test")
    PrinterNew().print()
    PrinterNew().print("test")
}