package me.lozm

import kotlin.reflect.KProperty

/**
 * val: compile 클래스 내부에 getter
 * var: compile 클래스 내부에 getter, setter
 * class 내부 코드 호출 순서는 위에서 아래 순이다.
 */

//abstract class Shape constructor(x: Int, y: Int) {
//    var x: Int = x
//        get() = field
//        set(value) {
//            field = value
//        }
//
//    val y: Int
//
//    init {
//        this.y = y
//    }
//
////    companion object {
////        fun createInstance(): Shape = Shape(0, 0);
////    }
//}

// 실행 순서
// 주 생성자, 부 생성자
//class Shape private constructor(val x: Int, val y: Int) {
//
//    var name: String = "Unknown name".also(::println)
//
//    init {
//        println("This is initial block1")
//    }
//
//    var color: String = "Unknown color".also(::println)
//
//    init {
//        println("This is initial block2")
//    }
//
//    constructor(x: Int, y: Int, name: String): this(x, y) {
//        println("My name is $name")
//    }
//
//    // 페이크 생성자
//    companion object {
//        fun Shape(x: Int, y: Int, name: String) = Shape(x, y).also {
//            println("My name is $name")
//        }
//    }
//}

//abstract class Shape constructor(private val x: Int, private val y: Int) {}

//abstract class Shape private constructor(private val x: Int, private val y: Int) {}

//abstract class Shape(private val x: Int, private val y: Int) {}

abstract class Shape(
    val x: Int,
    val y: Int
) {
    abstract val area: Double
}

interface DrawAble {
    fun draw() {
        println("DrawAble draw()")
    }
}

interface DrawAble2 {
    fun draw() {
        println("DrawAble draw()")
    }
}

open class Rectangle(
    x: Int,
    y: Int,
    val width: Int,
    val height: Int
) : Shape(x, y) {
    //    , DrawAble, DrawAble2 {
    override val area: Double
        get() {
//            super<DrawAble>.draw()
            return (width * height).toDouble()
        }
}

class Square(
    x: Int,
    y: Int,
    size: Int
) : Rectangle(x, y, size, size) {

}

class Circle(
    x: Int,
    y: Int,
    val radius: Int
) : Shape(x, y) {
    override val area: Double
        get() = radius * radius * PI // getter 코드

//    override val area: Double = radius * radius * PI // 초기화 코드

    val name: String by lazy {
        println("init")
        initName()
    }

    private fun initName() {
        "test"
    }

    companion object {
        const val PI = 3.141592
    }
}

private operator fun Any.getValue(circle: Circle, property: KProperty<*>): String {
    TODO("Not yet implemented")
}

data class Person(val name: String, val address: String)

//sealed class Result {
//    object Success : Result()
//    class Failure(val message: String) : Result()
//
//}
//
//fun load() = Result.Success


fun main() {
    val (name, address) = Person("junlee", "seoul")
    println("name = ${name}")
    println("address = ${address}")

//    val list = List<Person>
//    for ((name, address) in list) {
//        println("name = ${name}")
//        println("address = ${address}")
//    }

//    val result = load()
//    when (result) {
//        Result.Success -> onSuccess()
//        is Result.Failure  -> onFailure(result.message)
//    }
}