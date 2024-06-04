package com.curiozing.kotlinplay.kotlinFlow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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

    val scope = CoroutineScope(EmptyCoroutineContext)

    flow.onEach {
        println("Res $it")

    }.launchIn(scope)

    Thread.sleep(1000)

}