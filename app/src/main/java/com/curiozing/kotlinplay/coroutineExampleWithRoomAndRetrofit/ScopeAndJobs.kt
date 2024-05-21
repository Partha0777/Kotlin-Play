package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun main() {

    val jobException = CoroutineExceptionHandler { _, throwable ->
        println("Error $throwable")
    }

    //val scope = CoroutineScope(Job() +jobException)
    val scope = CoroutineScope(SupervisorJob() + jobException)

    scope.launch {
        delay(50)
        println("Start coroutine 1")
        withContext(NonCancellable) {
            println("Job clear....")
        }
        throw RuntimeException()
    }

    scope.launch {
        delay(500)
        println("Start coroutine 2")
    }.invokeOnCompletion { thowable ->
        if (thowable is CancellationException) {
            println("Coroutine 2 got cancelled")
        }
    }

    Thread.sleep(1000)
    println("is still Scope Active? ${scope.isActive}")

}