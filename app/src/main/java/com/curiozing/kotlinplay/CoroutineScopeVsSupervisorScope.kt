package com.curiozing.kotlinplay

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {

    var coroutineJob = CoroutineScope(Dispatchers.Default)

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


    var supervisorJob = CoroutineScope(SupervisorJob() +Dispatchers.Default)

    supervisorJob.launch {
        delay(100)
        println("Super Task 1")
    }

    supervisorJob.launch {
        delay(200)
        println("Super Task 2")
        throw RuntimeException()
    }

    supervisorJob.launch {
        delay(300)
        println("Super Task 3")
    }
    delay(2000)
}