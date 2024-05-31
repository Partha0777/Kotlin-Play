package com.curiozing.kotlinplay.kotlinFlow

import java.math.BigInteger

fun main() {
    println("factorial... ${calculateFactorial(5)}")
}

fun calculateFactorial(number: Int): BigInteger {

    var factorial = BigInteger.ONE
    for (i in 1..number) {
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
    }
    return factorial
}