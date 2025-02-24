package com.curiozing.kotlinplay.kotlinFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.math.BigInteger

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    println("Async Example1")

    testSuspend()

    launch {

        calculateFactorialList(5).collect {
            println("factorial...${System.currentTimeMillis() - startTime} - $it")
        }

    }
    println("Async Example2")
}

private fun calculateFactorialList(number: Int): Flow<BigInteger> = flow {
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        delay(100)
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        emit(factorial)
    }
}

suspend fun testSuspend() {
    delay(1000)
    println("testSuspend CALLED")
}