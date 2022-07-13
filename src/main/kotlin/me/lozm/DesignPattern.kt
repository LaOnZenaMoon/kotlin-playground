package me.lozm


object Singleton {
    fun createInstance(): Unit {}
}

fun String.lastChar() = this[length - 1]


fun main() {
    Singleton.createInstance()
    val lastChar = "string....".lastChar()
    println("lastChar = ${lastChar}")
}