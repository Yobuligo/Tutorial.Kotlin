import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Sometimes it is required to wait for a coroutine to be completed before continue.
 * This can be achieved by using the job object which is returned by launch
 */

fun main() {
    println("Before Run Blocking")
    runBlocking {
        val job1 = launch {
            println("Before first task")
            delay(2000)
            println("After first task")
        }

        // wait until the first jobs ends before the second job is started
        job1.join()
        launch {
            println("Before second task")
            delay(1000)
            println("After second task")
        }

        println("... runBlocking is continued")
    }
    println("After Run Blocking")
}