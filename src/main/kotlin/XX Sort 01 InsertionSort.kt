import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun insert(entry: Int, sortedList: MutableList<Int>, leftPos: Int, rightPos: Int) {
    if (sortedList.isEmpty()) {
        sortedList.add(entry)
        return
    }

    val posMiddle = (leftPos + rightPos) / 2
    val left = sortedList[posMiddle]
    val right: Int

    // only one neighbour to compare
    if (leftPos == rightPos) {
        if (entry < left) {
            sortedList.add(leftPos, entry)
        } else {
            sortedList.add(leftPos + 1, entry)
        }
        return
    }

    // right neighbour not available (no more neighbours)
    if (posMiddle + 1 >= sortedList.size) {
        sortedList.add(entry)
        return
    } else {
        right = sortedList[posMiddle + 1]
    }

    // fits between neighbours?
    if (left < entry && right > entry) {
        sortedList.add(posMiddle + 1, entry)
        return
    }

    // equals left or right?
    if (left == entry || right == entry) {
        sortedList.add(posMiddle + 1, entry)
        return
    }

    // insert left?
    if (entry < left) {
        insert(entry, sortedList, leftPos, posMiddle)
    } else {
        // insert right?
        insert(entry, sortedList, posMiddle + 1, rightPos)
    }
}

fun sort(list: List<Int>): List<Int> {
    val sortedList = mutableListOf<Int>()
    list.forEach { entry ->
        insert(entry, sortedList, 0, sortedList.size - 1)
    }
    return sortedList
}

fun insertionSortWikipedia(list: MutableList<Int>): List<Int> {
    val sortedList = list.toMutableList()
    for (i in 1 until sortedList.size) {
        val value = sortedList[i]
        var j = i
        while (j > 0 && sortedList[j - 1] > value) {
            sortedList[j] = sortedList[j - 1]
            j -= 1
        }
        sortedList[j] = value
    }
    return sortedList
}

fun main() {
    val number = 50000
    val list = mutableListOf<Int>()
    repeat(number) {
        list.add(Random.nextInt(0, number))
    }

    println(measureTimeMillis { sort(list) })
    println(measureTimeMillis { insertionSortWikipedia(list) })
}