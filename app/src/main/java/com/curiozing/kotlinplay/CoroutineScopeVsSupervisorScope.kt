package com.curiozing.kotlinplay

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Throwing Error: $throwable")
    }
    val coroutineJob = CoroutineScope(Dispatchers.Default + coroutineExceptionHandler)

    coroutineJob.launch {
        delay(100)
        println("Task 1")
    }
    coroutineJob.launch {
        delay(200)
        println("Task 2")
        throw RuntimeException()
    }
    coroutineJob.launch {
        delay(300)
        println("Task 3")
    }
    val supervisorJob =
        CoroutineScope(SupervisorJob() + Dispatchers.Default + coroutineExceptionHandler)

    supervisorJob.launch {
        delay(100)
        println("Super Task 1")
    }

    supervisorJob.launch {
        delay(200)
        throw RuntimeException()
        println("Super Task 2")
    }

    supervisorJob.launch {
        delay(300)
        println("Super Task 3")
    }
    delay(2000)
}