import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * As RunBlocking starts a Coroutine it is possible to execute functions in parallel.
 * With "launch" a new Coroutine can be created which is executed without blocking the thread in which it is executed
 *
 * Outside of the delay function it is usual that everything is executed on the main thread.
 * This means it is not executed in parallel. To execute it concurrent launch needs Dispatcher.Default has parameter.
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