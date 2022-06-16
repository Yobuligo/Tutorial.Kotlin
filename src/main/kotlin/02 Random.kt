import kotlin.random.Random

fun main(args: Array<String>) {
    var count: Int = 0
    val numberEntries = 20
    val hashMap = hashMapOf<Int, Int>()

    repeat(numberEntries) {
        hashMap.put(count, 0)
        count++
    }

    repeat(1000) {
        val number = Random.nextInt(numberEntries)
        hashMap.set(number, hashMap.get(number)!!.plus(1))
    }

    hashMap.forEach() {
        println("Number entries for ${it.key} was ${it.value}")
    }
}