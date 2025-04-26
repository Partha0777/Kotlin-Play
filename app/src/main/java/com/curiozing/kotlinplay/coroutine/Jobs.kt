package com.curiozing.kotlinplay.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val parent = CoroutineScope(Dispatchers.Default).launch {
        val job1 = launch {
            delay(1000)
            println("Task 1 done")
        }
        val job2 = launch {
            delay(500)
            println("Task 2 done")
        }
        joinAll(job1, job2)
        println("Parent job done after all child jobs")
    }

    parent.join()
}