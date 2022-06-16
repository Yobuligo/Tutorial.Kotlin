package com.outlivethesun.teamslimsterspringboot

/**
 * Any class which attributes have to be initialized
 */
class Object {
    var attr1: String = ""
}

/**
 * Class that is responsible for creating and initializing an object
 */
class ObjectInitializer<T> {
    /**
     * Hand over a lamda that is used as some kind of extension function on the generic type T
     * Each time extFun is called the developer has the possibility
     * to access the attributes of the instance to change it
     */
    fun new(extFun: T.() -> Unit): T {
        val newInstance = Object() as T
        newInstance.extFun()
        return newInstance
    }
}

fun main(args: Array<String>) {
    /**
     * create an instance of the objectInitializer
     * call method "new" to create an instance and call the handed over Lambda
     * to give the possibility to initialize the created object
     */
    val objectInitializer = ObjectInitializer<Object>()
    val initializedObject = objectInitializer.new { attr1 = "Test" }
}