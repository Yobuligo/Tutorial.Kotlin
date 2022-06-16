/**
 * Next to extension functions there is a possibility to add extension properties
 * This means to extend an existing class by a property (val or var)
 * The extension is available for all instances of the type
 */

/**
 * Define a variable (val or var) starting with the class which should be extended,
 * followed by a name and the name of the property.
 * The property behaves like any normal property
 */
val String.myExtensionProperty: Int
    get() {
        return this.length + 5
    }

fun main() {
    val helloWorld = "Hello World"
    println(helloWorld.myExtensionProperty)
}