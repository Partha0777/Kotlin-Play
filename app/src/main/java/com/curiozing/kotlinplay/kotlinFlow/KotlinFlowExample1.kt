package com.curiozing.kotlinplay.kotlinFlow

import java.math.BigInteger

fun main() {

    calculateFactorialList(5).forEach {
        println("factorial...${System.currentTimeMillis()} - $it")
    }
}

fun calculateFactorialList(number: Int): List<BigInteger> = buildList {
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        add(factorial)
    }
}