import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * RunBlocking starts a new coroutine.
 * It is executes sequentially with the thread. This means the thread in which it is executed waits until RunBlocking is finished
 */

fun main() {
    println("Before Run Blocking")
    runBlocking {
        println("Run Blocking before delay")
        delay(1000)
        println("Run Blocking after delay")
    }
    println("After Run Blocking")
}