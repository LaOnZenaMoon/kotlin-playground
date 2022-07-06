package me.lozm

// [?]: nullable
// [?.]: null safe
// [?:](elvis operator): set up default value
// [!!]: not nullable

class Type {
    fun foo(): Int {
        println("foo")
        return 3
    }
}

fun printFoo(a: Type?) {
    val result = a?.foo()?.dec() ?: -1
    println(result)
}

fun throwNullPointerException(a: Type?) {
    a!!.foo()
}



fun testElvisOperator(type: Type?) {
    type ?: run {
        println("parameter is null")
        return
    }
    val result = type.foo()
    println(result)
}

fun main() {
    printFoo(null)
    printFoo(Type())
    testElvisOperator(null)
    throwNullPointerException(null)
}
