interface IInstance

interface IFactory {
    fun create(): IInstance
    fun createByString(value: String): IInstance
}

class Instance : IInstance

class Factory : IFactory {
    override fun create(): IInstance {
        return Instance()
    }

    override fun createByString(value: String): IInstance {
        return Instance()
    }
}

/**
 * Creates a factory class and avoid inheriting from Factory
 * Methods of the base class can be overwritten
 */
class Factory02 : IFactory by Factory(){
    override fun createByString(value: String): IInstance {
        return Instance()
    }
}

/**
 * Creates a factory class and avoid calling composition methods
 * Instead the delegate factory is handed over to the constructor
 * and each method call of IFactory is delegated to "factory"
 */
class Factory03(factory: IFactory) : IFactory by factory

fun main(args: Array<String>) {

}