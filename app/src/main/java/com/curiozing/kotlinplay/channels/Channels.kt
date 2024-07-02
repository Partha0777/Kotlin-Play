package com.curiozing.kotlinplay.channels

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main(): Unit = coroutineScope {

    val channel = produce {

        send(10)
        delay(1000)

        send(20)
        delay(1000)

        send(30)
        delay(1000)

        send(40)
        delay(1000)
    }


    launch {
        channel.consumeEach {
            println("Consumer 1 $it")
        }
    }

    launch {
        channel.consumeEach {
            println("Consumer 2 $it")
        }
    }

    //Kotlin Coroutine example
       /* val  coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception is $throwable")
        }
        val coroutineScopeJob = CoroutineScope(Dispatchers.Default+coroutineExceptionHandler)

        coroutineScopeJob.launch {
            delay(500)
            println("Job 1")
        }

        coroutineScopeJob.launch {
            delay(700)
            throw RuntimeException()
            println("Job 2")
        }

        coroutineScopeJob.launch {
            delay(1000)
            println("Job 3")
        }*/


}