import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        launch {
            val result = measureTimeMillis {
                val job1 = launch {
                    delay(3000)
                    println("Child 1")
                }

                val job2 = launch {
                    delay(1500)
                    println("Child 2")
                }

                val job3 = launch {
                    delay(100)
                    println("Child 3")
                }
                println("before join")
                job1.join()
                println("after join 1")
                job2.join()
                println("after join 2")
                job3.join()
                println("after join 3")
            }
            println("All Done in ${result}")
        }
    }
}
