import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * It is no problem to start thousands of Coroutines at once
 */

fun main() {
    println("Before Run Blocking")
    runBlocking {
        repeat(100000) {
            launch {
                delay(5000)
                println(it)
            }
        }
    }
    println("After Run Blocking")
}