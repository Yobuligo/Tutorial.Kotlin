import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * The CoroutineScope is used by Coroutines.
 * The difference to RunBlocking which blocks a whole thread is that it only suspends (stilllegen, unterbrechen) the thread.
 * Therefor it has to be called within a Coroutine or within a suspend function.
 * This means CoroutineScope is a suspend function by themselves.
 * This also means runBlocking injects a CoroutineScope:
 * runBlocking{ this = CoroutineScope }
 */

suspend fun runCoroutineScope() = coroutineScope {
    println("Start CoroutineScope ")
    delay(1000)
    println("Complete CoroutineScope ")
}

fun main() {
    println("Before Run Blocking")
    runBlocking {
        runCoroutineScope()
    }
    println("After Run Blocking")
}