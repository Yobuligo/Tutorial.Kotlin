fun main() {
    val maxValue = 3

    println("Counts up from 1 to $maxValue, assign the value to x and call the for-loop body")
    for (x in 1..maxValue) {
        println(x)
    }

    println("\nCounts up from 1 to ${maxValue - 1} (everything beside $maxValue), assign the value to x and call the for-loop body")
    for (x in 1 until maxValue) {
        println(x)
    }

    println("\nCounts down from $maxValue to 1, assign the value to x and call the for-loop body")
    for (x in maxValue downTo 1) {
        println(x)
    }

    println("\nCounts up from 1 to $$maxValue but take only every second step, assign the value to x and call the for-loop body")
    for (x in 1..maxValue step 2) {
        println(x)
    }
}