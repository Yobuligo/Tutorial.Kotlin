interface ILazy<T> {
    val value: T
}

class Lazy<T>(private val creation: () -> T) : ILazy<T> {
    private var _value: T? = null

    override val value: T
        get() {
            if (_value == null) {
                _value = creation()
            }

            return _value!!
        }
}

class Customer {
    val name = "My Name"
}

fun main() {
    val lazyCustomer = Lazy<Customer> { return@Lazy Customer() }
    println(lazyCustomer.value.name)
}