package com.curiozing.kotlinplay.kotlinVsJava.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val scope = CoroutineScope(Job())

    scope.launch {
        launch {
            delay(1000)
            println("Line 1")
        }

        callOuterFunction()

        launch {
            delay(200)
            println("Line 2")
        }

    }

    Thread.sleep(3000)
}

suspend fun callOuterFunction() {
    delay(2000)
    println("Suspended called")

}