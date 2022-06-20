import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureNanoTime

/**
 * The current example shows the parallel execution of a task.
 * To run the executions in parallel on different threads (worker threads) the Dispatcher is set
 */

fun createUnsortedList(number: Int): List<Int> {
    return mutableListOf<Int>().apply {
        repeat(number) {
            add(Random.nextInt(0, number))
        }
    }
}

fun cloneUnsortedList(list: List<Int>): MutableList<Int> {
    return mutableListOf<Int>().apply {
        addAll(list)
    }
}

fun sortList(list: MutableList<Int>) {
    println("Start sorting on Thread ${Thread.currentThread()}. ")
    println("Sorting on Thread ${Thread.currentThread()} took: ${
        measureNanoTime { list.sort() }
    }")
}

fun main() {
    val number = 3000000
    val maxConcurrent = 20
    val list = createUnsortedList(number)

    println("Run WITHOUT explicit dispatcher. Executed in Main Thread and sequentially (as no Dispatcher) took: ${
        measureNanoTime {
            runBlocking {
                repeat(4) { launch { sortList(cloneUnsortedList(list)) } }
            }
        }
    }")

    println()
    println("Run WITH explicit dispatcher. Executed in several Worker Threads and concurrent execution took: ${
        measureNanoTime {
            runBlocking {
                repeat(4) { launch(Dispatchers.Default) { sortList(cloneUnsortedList(list)) } }
            }
        }
    }")

    println()
    println("Run WITH explicit dispatcher for $maxConcurrent concurrent executions. Executed in several Worker Threads and concurrent execution took: ${
        measureNanoTime {
            runBlocking {
                repeat(maxConcurrent) {
                    launch(Dispatchers.Default) { sortList(cloneUnsortedList(list)) }
                }
            }
        }
    }")
}