/**
 * In case a parameter with a generic type is required to call methods on it
 * Then it is required to write a lot of code and to give the generic type
 * It is easier to extend the class type of the given parameter object and provide the content by lambda
 */

class Achievement {
    val id = 5
    val name = 6
}

/**
 * Responsible for saving the order of properties
 * either ascending or descending
 */
class OrderBy<T> {
    fun asc(property: T.() -> Unit): OrderBy<T> {
        return this
    }

    fun desc(property: T.() -> Unit): OrderBy<T> {
        return this
    }
}

/**
 * PROBLEM
 */
class DataAccessObjectProblem<T> {
    /**
     * function to findAll elements. In addition, an object can be handed over to provide the sort order
     */
    fun findAll(orderBy: OrderBy<T>) {}
}

class Problem {
    fun show() {
        /*
            not only that the DataAccessObjectProblem needs the generics Type
            The type is also required for the OrderBy instance
            And the OrderBy object instances has to be created by yourself
         */
        val dataAccessObject = DataAccessObjectProblem<Achievement>()
        dataAccessObject.findAll(OrderBy<Achievement>().asc { name }.desc { id })
    }
}

/**
 * SOLUTION
 */
class DataAccessObjectSolution<T> {
    /**
     * function to findAll elements. In addition, an object can be handed over to provide the sort order
     */
    fun findAll(orderBy: OrderBy<T>.() -> Unit) {}
}

class SolutionExample {
    fun showExample() {
        /*
            The generics type only has to be provided when creating the DataAccessObject.
            Furthermore, there is no need to create an OrderBy object instance by yourself
         */
        val solution = DataAccessObjectSolution<Achievement>()
        solution.findAll {
            asc { name }
            desc { id }
        }
    }
}