package com.curiozing.kotlinplay.kotlinFlow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

fun main() {

    val flow = flow {
        kotlinx.coroutines.delay(300)
        emit("Hello 1")

        kotlinx.coroutines.delay(300)
        emit("Hello 2")

        kotlinx.coroutines.delay(300)
        emit("Hello 3")
    }

   /* runBlocking {
        flow.collect{
            println("Res $it")
        }
        println("After Flow")
    }
*/
    val scope = CoroutineScope(EmptyCoroutineContext)

    flow.map {
        "$it mapped"
    }.onStart {
        println("It's get started")
    }.onEach {
        println("Res $it")
    }.onCompletion {
        println("It got end...")
    }.launchIn(scope)
    println("After Flow")

    Thread.sleep(1000)

}