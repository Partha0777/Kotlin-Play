package com.curiozing.kotlinplay.kotlinVsJava.coroutine

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.ClassCastException

fun main() {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("Exceptions is $throwable")
    }

    val job = CoroutineScope(SupervisorJob() + exceptionHandler)

    job.launch {

        try {
            coroutineScope {
                launch {
                    delay(100)
                    throw RuntimeException("Simulated failure in Job 2")
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
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

    job.launch {
        launch {
            delay(500)
            println("Another Running job 2")

        }

    }

    Thread.sleep(1000)

}

suspend fun callAnotherFunction() {
    delay(700)
    println("Running Another Job")

}
