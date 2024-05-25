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
            println("Line 1")
        }

        callOuterFunction()

        launch {
            println("Line 2")
        }

    }

    Thread.sleep(2000)
}

suspend fun callOuterFunction(){
    delay(1000)
    println("Suspended called")

}