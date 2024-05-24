package com.curiozing.kotlinplay.inlineFunctions

class InlineFunctionExample1 {

    private lateinit var hello: String
    fun runSomething() {
        var run = hello;
    }

}

fun main() {
    val numbers = listOf(1, 2)

    multiply(numbers) {
        it * 2
    }
}

inline fun multiplyNumber(list: List<Int>, multiply: (Int) -> Int) {
    for (item in list) {
        val value = multiply(item)
        println("Value is $value")
    }
}