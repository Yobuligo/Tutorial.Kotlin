import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Dispatchers are responsible for deciding which thread should be used. E.g. to use the main thread, a default or an own defined thread
 * Dispatchers can be defined within the coroutines functions like launch and async
 * To set main seems to work only for Android
 */

fun main() {
    runBlocking {
        launch(Dispatchers.Unconfined) {
            delay(1000)
            println("Dispatchers.Main 1 is finished within thread: ${Thread.currentThread()}")
        }
        launch(Dispatchers.Unconfined) {
            delay(1000)
            println("Dispatchers.Main 2 is finished within thread: ${Thread.currentThread()}")
        }

        launch {
            delay(1000)
            println("Dispatchers.Default is finished within thread: ${Thread.currentThread()}")
        }
    }
}