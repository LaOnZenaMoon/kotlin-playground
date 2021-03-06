package me.lozm

fun main(args: Array<String>) {
    fitInRange(1)
    checkOutOfRange()
    describeWhen(2)
    val items = listOf("apple", "banana", "avocado", "kiwifruit")
    printWhen(items)
    val stringLength = getStringLength("apple")
    println("stringLength = $stringLength")

    val max = max(1, 2)
    println(max)

    val gender = convertGender("M")
    println(gender)

    val hasPrefix = hasPrefix("")
    println(hasPrefix)
}

fun hasPrefix(s: Any) = when(s) {
    // java instanceOf -> kotlin is
    // is -> auto type casting(Any -> String, Int...)
    is String -> s.startsWith("prefix")
    is Int -> s.inc()
    else -> false
}

fun convertGender(gender: String): String {
    return when(gender) {
        "M", "F" -> "Male or Female"
        else -> "Unknown"
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

private fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null

    return obj.length
}

private fun printWhen(items: List<String>) {
    // java switch -> kotlin when
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}

private fun describeWhen(obj: Any): String {
    return when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }
}


private fun checkOutOfRange() {
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
}

private fun fitInRange(x: Int) {
    val y = 9
    if (x in 1..y + 1) {
        println("Item $x is fits in range")
    }
}