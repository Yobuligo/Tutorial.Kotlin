/**
 * Probably Generics shouldn't be used in case T should represent the current type itself.
 * Assume there is an interface ICloneable which should create a copy of an object and return the object typesafe. E.g.:
 * interface ICloneable<T>{
 *      fun clone(): T
 * }
 *
 * In other languages clone() would only return an object of type "object", as T couldn't refer to the current type itself.
 * Example: IElement extends ICloneable. T couldn't be the type of the type itself.
 * interface IElement: ICloneable<T>
 *
 * For that reason Generics should probably be used to return a type (T) of the implemented interface / class
 *
 * Anyway there is a solution especially in Kotlin and maybe some other would work as well:
 */

/**
 * 1. ICloneable gets a function which contains the generic type
 *  fun <T> clone(): T
 *  So there is no need to provide T when interface IElement extends ICloneable
 *  Only if the interface IElement has to be implemented e.g. in Button, T has to be replaced by the specific type.
 *  But it seems that is not possible. Instead, it also means that Button has a method clone and T could be provided.
 */

interface ICloneable1 {
    fun <T> clone(): T
}

interface IElement1 : ICloneable1 {
    val name1: String
}

class Button1(override val name1: String) : IElement1 {
    override fun <T> clone(): T {
        TODO("Not yet implemented")
    }
}

/**
 * 2. usage of a companion object
 */
interface IElement2 {
    val name2: String
}

open class ElementCompanionObject2<T : IElement2> {
    fun clone(instance: T): T {
        TODO()
    }
}

class Button2(override val name2: String) : IElement2 {
    companion object : ElementCompanionObject2<Button2>()
}


/**
 * 3. an Extension function for T: IElement. What really works
 */
interface IElement3 {
    val name3: String
}

fun <T : IElement3> T.clone(): T {
    TODO()
}

class Button3(override val name3: String) : IElement3


fun main() {
    val button1 = Button1("Test1")
    button1.clone<Button1>().name1

    val button2 = Button2("Test3")
    Button2.clone(button2).name2

    val button3 = Button3("Test2")
    button3.clone().name3
}