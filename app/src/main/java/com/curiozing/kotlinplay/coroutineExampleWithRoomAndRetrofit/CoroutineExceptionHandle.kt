package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun main() {

    val coroutineException = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Coroutine Exception: $throwable")
    }
    val job = CoroutineScope(Job())

    job.launch {

        launch(coroutineException) {
            launch(coroutineException) {
            }

        }
    }

    Thread.sleep(500)
}