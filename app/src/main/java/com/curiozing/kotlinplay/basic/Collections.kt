package com.curiozing.kotlinplay.basic

fun main() {
    //* Mapping *//

    //map
    val numbers = listOf(1, 2, 3)
    val squared = numbers.map { it * it }
    println(squared)

    //mapIndexed
    val words = listOf("a", "bb", "ccc")
    val indexedWords = words.mapIndexed { index, value -> "$index: $value" }
    println(indexedWords) // Output: [0: a, 1: bb, 2: ccc]

}