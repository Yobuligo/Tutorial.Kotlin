import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Suspend Functions are specific functions which only can be called within a coroutine or another suspend function.
 * In addition, they provide access to other suspend functions
 */

suspend fun waitAndPrint(text: String) {
    println(text)
    delay(1000)
    println("Suspend Function was executed")
}

fun main() {
    println("Before Run Blocking")
    runBlocking {
        waitAndPrint("WaitAndPrint is started")
    }
    println("After Run Blocking")
}