/**
 * It is possible to provide a separate iterator which can be used with the FOR-loop of Kotlin.
 * Therefor the Iterator has to provide the specific Operations next() and hasNext()
 */

class MyIterator {
    private var hasNext = true

    operator fun iterator(): MyIterator {
        return this
    }

    operator fun next(): Int {
        return 123
    }

    operator fun hasNext(): Boolean {
        return if (hasNext) {
            hasNext = false
            true
        } else {
            false
        }
    }
}

fun main() {
    val myIterator = MyIterator()
    for (value in myIterator) {
        println(value)
    }
}