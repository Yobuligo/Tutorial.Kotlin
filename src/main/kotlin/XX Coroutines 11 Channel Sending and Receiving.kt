import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Channels can be used to send data from one Coroutine to another.
 * The opposite of sending is receiving.
 * The channel has to know which data will send
 */

fun main() {
    runBlocking {
        val channel = Channel<Int>()
        launch {
            delay(2000)
            channel.send(123)
        }
        launch {
            println("Waiting")
            // Wait until the value was send
            val result = channel.receive()
            println("Result ${result} received")
        }
    }
}
