import kotlin.reflect.KClass

enum class TreeType {
    LEAF,
    NEEDLE,
    PALM
}

fun main() {
    val enumType: KClass<out Enum<*>> = TreeType::class
    enumType.java.enumConstants.forEach { enum ->
        println(enum)
    }
}