package com.curiozing.kotlinplay.kotlinFlow

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

fun main() {
    val randomList = mutableListOf(2, 59, 9, 6, 8)
    val tempList = mutableListOf<Int>()

    while (randomList.isNotEmpty()) {
        val max = randomList.min()
        tempList.add(max)
        randomList.remove(max)
    }

    println("Max -> $tempList")
}
