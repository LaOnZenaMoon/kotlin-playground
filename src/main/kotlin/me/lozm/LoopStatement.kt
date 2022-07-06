package me.lozm

fun main(args: Array<String>) {
    val items = listOf("apple", "banana", "avocado", "kiwifruit")
    printItemUsingForLoop(items)
    printItemUsingWhileLoop(items)
    streamApi(items)
    printCharacter()
}

fun printCharacter() {
    for (i in 'a' .. 'e') println(i)
    for (i in 'a' until 'e') println(i)
    for (i in ('a' until 'e').reversed()) println(i)
    val intArray = arrayOf(0, 1, 2, 3, 4)
    for (index in intArray.indices) {
        print(index)
    }
}

private fun streamApi(items: List<String>) {
    items.filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

private fun printItemUsingWhileLoop(items: List<String>) {
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

private fun printItemUsingForLoop(items: List<String>): List<String> {
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    return items
}