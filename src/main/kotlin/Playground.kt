import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.Instant
import java.util.Date
import kotlin.random.Random
import kotlin.system.measureNanoTime

fun BubbleSort(entries: List<Int>): List<Int> {
    val innerEntries = mutableListOf<Int>()
    innerEntries.addAll(entries)
    for (i in 0..innerEntries.size - 1) {
        for (k in i + 1 until innerEntries.size) {
            if (innerEntries[i] > innerEntries[k]) {
                val entry = innerEntries[i]
                innerEntries[i] = innerEntries[k]
                innerEntries[k] = entry
            }
        }
    }
    return innerEntries
}

fun KotlinSort(entries: List<Int>): List<Int> {
    val innerEntries = mutableListOf<Int>()
    innerEntries.addAll(entries)
    innerEntries.sort()
    return innerEntries
}

fun PeterSort(entries: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    val innerEntries = mutableListOf<Int>()
    innerEntries.addAll(entries)
    var entry: Int? = null

    while (innerEntries.size != 0) {
        entry = null
        for (i in 0..innerEntries.size - 1) {
            if (entry == null) {
                entry = innerEntries[i]
            } else if (innerEntries[i] < entry) {
                entry = innerEntries[i]
            }
        }
        result.add(entry!!)
        innerEntries.remove(entry)
    }

    return result
}

fun main() {
    val myList = mutableListOf<Int>()
    repeat(50000) {
        myList.add(Random.nextInt(0, 50000))
    }
    println("start")
    runBlocking {
        launch {
            println("Start KotlinSort ${Date.from(Instant.now())} Thread: ${Thread.currentThread()}")
            println(
                "Kotlin Sort: ${
                    measureNanoTime {
                        KotlinSort(myList)
                    }
                }"
            )
        }

        launch {
            println("Start PeterSort ${Date.from(Instant.now())} Thread: ${Thread.currentThread()}")
            println(
                "Peter Sort: ${
                    measureNanoTime {
                        PeterSort(myList)
                    }
                }"
            )
        }

        launch {
            println("Start BubbleSort ${Date.from(Instant.now())} Thread: ${Thread.currentThread()}")
            println(
                "Bubble Sort: ${
                    measureNanoTime {
                        BubbleSort(myList)
                    }
                }"
            )
        }

        println("Waiting")
    }

}
