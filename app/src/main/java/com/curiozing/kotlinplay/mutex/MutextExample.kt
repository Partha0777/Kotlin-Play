package com.curiozing.kotlinplay.mutex

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


val mutex = Mutex()
var count = 0

fun main() = runBlocking {

    coroutineScope {
        repeat(5) {
            launch {
                delay(1000)
                increaseCount()
            }
        }
    }

    println("Final count: $count")
}

suspend fun increaseCount() {
    mutex.withLock {
        count += 1
        println("Count increased to $count by ${Thread.currentThread().name}")
   }
}

suspend fun decreaseCount() {
    mutex.withLock {
        count -= 1
        println("Count decreased to $count by ${Thread.currentThread().name}")
    }
}
