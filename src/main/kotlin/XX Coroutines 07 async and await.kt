import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * With function async Coroutines can be created that returns a specific result. Async returns an object which provides access to the result.
 * With function await it is possible to retrieve the result of async as soon it is returned
 */

fun main() {
    runBlocking {
        println("Before starting calculations")
        val firstCalc = async { 1 + 2 }
        val secondCalc = async {
            delay(2000)
            10 + 20
        }
        val thirdCalc = async { 100 + 200 }
        println("After starting calculations")

        println("Retrieving result as soon as each calculation has finished")
        val result = firstCalc.await() + secondCalc.await() + thirdCalc.await()
        println("The result is $result")
    }
}