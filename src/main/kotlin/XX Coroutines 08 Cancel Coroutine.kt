import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Sometimes it is required to cancel a Coroutine.
 * This can be achieved as follows.
 */

fun main() {
    runBlocking {
        // start concurrent execution
        val job = launch {
            repeat(1000) {
                delay(300)
                println("Work $it is done")
            }
        }

        // wait a moment and cancel the job
        delay(2000)
        println("Tired from waiting. Cancel!")
        job.cancel()
        job.join()
        println("End of work!")
    }
}