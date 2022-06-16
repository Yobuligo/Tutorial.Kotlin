import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * As RunBlocking starts a Coroutine it is possible to execute functions in parallel.
 * With "launch" a new Coroutine can be created which is executed without blocking the thread in which it is executed
 */

fun main() {
    println("Before Run Blocking")
    runBlocking {
        launch {
            println("Before first task")
            delay(2000)
            println("After first task")
        }

        // the following coroutine will end before the previous one. Both are executed concurrent
        launch {
            println("Before second task")
            delay(1000)
            println("After second task")
        }
    }
    println("After Run Blocking")
}