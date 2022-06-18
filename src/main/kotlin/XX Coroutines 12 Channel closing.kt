import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * A channel can be closed to say that no more elements will follow.
 */

fun main() {
    runBlocking {
        val channel = Channel<Int>()
        launch {
            println("1 says: calculate")
            repeat(3) {
                delay(300)
                channel.send(it)
            }
            println("1 says: calculation canceled, close channel instead of sending result")
            channel.close()
        }
        launch {
            println("2 says: waiting for result")
            for (y in channel) {
                println("2 says: received value is ${y}")
            }
            println("2 says: leaving")
        }
    }
}