package com.curiozing.kotlinplay.kotlinVsJava.coroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.ClassCastException

fun main() {

    val job = CoroutineScope(SupervisorJob())

    job.launch {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            // Handle the exception from Job 2 here (e.g., log it)
            println("Caught exception in Job 2: $throwable")
        }

        launch(exceptionHandler) {
            delay(100)
            println("Running job 2")
            throw RuntimeException()
        }

        launch {
            delay(200)
            println("Running job 1")
        }

        launch {
            delay(400)
            println("Running job 3")
        }
    }

    /*
        job.launch {
            launch {
                delay(500)
                println("Another Running job 2")

            }

        }
    */

    Thread.sleep(1000)

}

suspend fun callAnotherFunction() {
    delay(700)
    println("Running Another Job")

}
