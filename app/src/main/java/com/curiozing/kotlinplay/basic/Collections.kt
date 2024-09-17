package com.curiozing.kotlinplay.basic

fun main() {
    //* Mapping *//

    //map
    val numbers = listOf(1, 2, 3)
    val squared = numbers.map { it * it }
    println(squared)

}