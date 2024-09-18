package com.curiozing.kotlinplay.basic

fun main() {
    //* Mapping *//

    //map
    val numbers = listOf(1, 2, 3)
    val squared = numbers.map { it * it }
    println(squared)

    //mapIndexed
    val words = listOf("a", "b", "c")
    val indexedWords = words.mapIndexed { index, value -> "$index: $value" }
    println(indexedWords)
    // Output: [0: a, 1: b, 2: c]


    //mapNotNull
    val numbers1 = listOf(1, 2, 3)
    val evenOrNull = numbers1.mapNotNull { if (it % 2 == 0) it else null }
    println(evenOrNull) // Output: [2]


    val indexedEvenLength = words.mapIndexedNotNull { index, value ->
        if (value.length % 2 == 0) "$index: $value" else null
    }
    println(indexedEvenLength) // Output: [1: bb]



}