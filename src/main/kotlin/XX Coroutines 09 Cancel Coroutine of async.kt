import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * As async returns a deferred value but not a job (like launch does) it is required to access the job via the deferred object.
 */

fun main() {
    runBlocking {
        println("Before starting calculations")
        val firstCalc = async { 1 + 2 }
        val secondCalc = async {
            try {
                delay(2000)
                10 + 20
            } finally {
                println("Second calc not finished")
            }
        }
        val thirdCalc = async { 100 + 200 }
        println("After starting calculations")

        // Cancel directly or alternatively via job: secondCalc.job.cancel()
        secondCalc.cancelAndJoin()
        println("Retrieving result as soon as each calculation has finished")
        val result = if (secondCalc.isCancelled) {
            firstCalc.await() + thirdCalc.await()
        } else {
            firstCalc.await() + secondCalc.await() + thirdCalc.await()
        }
        println("Expected result is 333. The result is $result")
    }
}