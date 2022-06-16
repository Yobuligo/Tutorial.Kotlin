/**
 * The keyword "out" can be used to declare that a variable / parameter which has a generics type
 * accept either a variable of the exact same type incl. the generics type
 * or that variables are accepted that have the same generics type or subtypes.
 * "Accept" means if you can assign an existing variable to another
 * That makes sense as you can ensure that it is possible to call each function polymorph
 *
 * What it is not: It is not about import parameter of e.g. T. Here always T and subtypes are meant
 *
 * Some other thoughts might be:
 * out is required if you declare a variable for the heap (memory). You can either declare that the heap
 * only takes variable with a specific generics type or a variable with a specific generic type incl. subtypes.
 * On the other hand you can have functions which took generic objects. These objects are already existing at the heap.
 * They will only injected in a function
 */

interface ICreature
interface IHuman : ICreature
interface IPlant : ICreature
interface IHouse<T>

class Human : IHuman
class Plant : IPlant
class House<T> : IHouse<T>
class Cellar<T> {
    fun moveInto(inhabitant: T) {}
}

fun main() {
    val houseHuman = House<IHuman>()
    val house: House<out ICreature> = houseHuman //only works as T of House is of type "out ICreature"

    val cellar = Cellar<ICreature>()
    cellar.moveInto(Human())
    cellar.moveInto(Plant())
}