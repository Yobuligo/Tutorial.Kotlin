import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Delegate : ReadWriteProperty<Any?, String> {
    private var myValue: String = "Test"

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return myValue
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        myValue = value
    }
}

fun delegate(something: () -> Unit): Delegate {
    return Delegate()
}

fun main(args: Array<String>) {
    var test2: String by Delegate()
    test2 = "Ken Miles"
    test2 = "Henry Ford"

    var test: String by delegate { println("here im Delegate") }
    test = "Ken Miles"
    test = "Henry Ford"
    println(test)
}