/**
 * A more easy example how to access attributes of a type that is provided as a generic type
 */

class MyConcreteType {
    var attribute1 = ""
    var attribute2 = ""
}

class Client<T> {
    fun accessAttributes(instance: T, accessFunction: T.() -> Unit) {
        accessFunction(instance)
    }
}

fun main() {
    val concreteType = MyConcreteType()
    Client<MyConcreteType>().accessAttributes(concreteType) {
        attribute1 = "attribute 1 changed"
        attribute2 = "attribute 2 changed"
    }
}