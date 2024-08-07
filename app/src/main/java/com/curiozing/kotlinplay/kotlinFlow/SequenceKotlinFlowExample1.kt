package com.curiozing.kotlinplay.kotlinFlow

import java.math.BigInteger

fun main() {
     val startTime = System.currentTimeMillis()
    calculateFactorialList(5).forEach {
        println("factorial...${System.currentTimeMillis() - startTime} - $it")
    }
    palindrome("Nitin")
}

fun palindrome(string: String){

    var data =  string.lowercase().reversed()

    if (data == string.lowercase()){
        println("It's Palindrome")
    }else{
        println("It's not Palindrome")
    }


}

private fun calculateFactorialList(number: Int): Sequence<BigInteger> = sequence{
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        Thread.sleep(1000)
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        yield(factorial)
    }
}