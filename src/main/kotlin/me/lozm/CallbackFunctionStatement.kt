package me.lozm

fun main() {
    val result1 = addFunction1(1, 3)
    println(result1)

    val callbackFunction1 = ::addFunction1
    println(callbackFunction1(2, 4))

    val result2 = { a: Int, b: Int -> a+b }
    println(result2)

    val plus2 = fun(x: Int): Int = ::plus.partial(2)(x)
    val plus3 = fun(x: Int): Int = ::plus.partial(3)(x)
    println(plus3(3))

    invokeErrorCallback1 ({ message -> println(message) })
    /**
     * () 인자 구문 밖에서 콜백 함수를 정의해서 넘겨줄 수 있다.
     * callApi
     * success {}
     * error {}
     */
    invokeErrorCallback1 { message -> println(message) }

    invokeErrorCallback1(::println)

    // kotlin 에서 java function 을 호출할 때는 안 된다.
    // kotlin 에서 kotlin function 을 호출할 때만 된다.
    invokeApi(
        param = 3,
        successCallback = { println("Success: $it") },
        errorCallback = { println("Error: $it") }
    )
}

fun invokeApi(
    param: Int,
    successCallback: (Int) -> Unit,
    errorCallback: (String) -> Unit
) {

    val success = true
    val result = 5

    if (success) {
        successCallback(result)
    } else {
        errorCallback.invoke("Error message")
    }
}

fun invokeErrorCallback1(errorCallback: (String) -> Unit) {
    val error = true
    if (error) {
        errorCallback("Error message")
//        errorCallback.invoke("Error message") // invoke 생략 가능
    }
}

fun invokeErrorCallback2(errorCallback: ((String) -> Unit)?) {
    val error = true
    if (error) {
        errorCallback?.invoke("Error message")
//        errorCallback.invoke("Error message") // invoke 생략 가능
    }
}

fun addFunction1(a: Int, b: Int): Int {
    return a + b
}

fun plus(x: Int, y: Int) = x + y

fun <P1, P2, R>
        ((P1, P2) -> R).partial(p1: P1): (P2) -> R {
    return { p2 -> this(p1, p2)}
}

//fun higherOrderFunction(function: (Int, Int) -> Int): (Int) -> Int {
//    return function
//}
