import kotlin.reflect.KClass

/**
 * Often we use generics to build frameworks.
 * And often we need information about the generics type (T)
 * In that case you need inline functions with reified types in extension functions
 * Those inline functions are used to define the origin type of T by tracking the whole code line while compiling it.
 *      If e.g. the inline function which has T is called once for type Int and String the code exists exactly 2 time during compile time. Once for Int and Once for String.
 * But in case you lose T at any point e.g. because you replace it by * or Any the information is gone forever.
 * So it is recommended to work with KClass<T> instead.
 *
 * The following example shows how to implement a builder by using generics without losing the type information
 * from an object of KClass<T> is created from T
 */

/**
 * 1. Create class for class to be created. It has KClass<T> as a constructor parameter
 */
class Product<T : Any>(type: KClass<T>, val name: String)

/**
 * 2. Create a builder witch needs the type (KClass<T>) as constructor parameter
 */
class Builder<T : Any>(private val type: KClass<T>) {
    private var name: String = ""

    fun setName(name: String): Builder<T> {
        this.name = name
        return this
    }

    fun build(): Product<T> {
        return Product<T>(type, name)
    }
}

/**
 * 3. Create extension inline function that looks like the constructor of the Builder. It is used instead of the constructor
 * And it provides access to the type information of T. It returns an instance of the Builder itself.
 */
inline fun <reified T : Any> Builder() = Builder(T::class)

/**
 * 4. Use the extension function with generics type to create an instance of the Builder
 */
fun main() {
    val product = Builder<String>().setName("Product name").build()
    println(product.name)
}