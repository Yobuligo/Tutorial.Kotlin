data class Store01<A>(val a: A)
data class Store02<A, B>(val a: A, val b: B)
data class Store03<A, B, C>(val a: A, val b: B, val c: C)
data class Store04<A, B, C, D>(val a: A, val b: B, val c: C, val d: D)
data class Store05<A, B, C, D, E>(val a: A, val b: B, val c: C, val d: D, val e: E)

class StoreFactory {
    fun <A> store(a: A): Store01<A> {
        return Store01(a)
    }

    fun <A, B> store(a: A, b: B): Store02<A, B> {
        return Store02(a, b)
    }

    fun <A, B, C> store(a: A, b: B, c: C): Store03<A, B, C> {
        return Store03(a, b, c)
    }

    fun <A, B, C, D> store(a: A, b: B, c: C, d: D): Store04<A, B, C, D> {
        return Store04(a, b, c, d)
    }

    fun <A, B, C, D, E> store(a: A, b: B, c: C, d: D, e: E): Store05<A, B, C, D, E> {
        return Store05(a, b, c, d, e)
    }
}

class Phone {
    val number = 123
}

class DriverLicense {
    val expiredAt = 123
}

class Person {
    val firstname = "Stacey"
}

fun main() {
    val storeFactory = StoreFactory()
    storeFactory.store(Phone(), Phone(), DriverLicense(), Person()).apply {
        a.number
        b.number
        c.expiredAt
        d.firstname
    }

    storeFactory.store(Person(), DriverLicense()).apply {
        a.firstname
        b.expiredAt
    }
}