package com.curiozing.kotlinplay.kotlinFlow

import java.math.BigInteger

fun main() {
     var startTime = System.currentTimeMillis()
    calculateFactorialList(5).forEach {
        println("factorial...${System.currentTimeMillis() - startTime} - $it")
    }
    println("Sync Only")
}

private fun calculateFactorialList(number: Int): Sequence<BigInteger> = sequence{
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        Thread.sleep(1000)
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        yield(factorial)
    }
}