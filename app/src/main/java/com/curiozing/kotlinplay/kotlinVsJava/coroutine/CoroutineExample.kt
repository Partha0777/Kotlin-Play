package com.curiozing.kotlinplay.kotlinVsJava.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineExample {
    fun startCoroutine() {
        CoroutineScope(Dispatchers.Main).launch {


        }
    }
}

fun main() {
    val job = CoroutineScope(Dispatchers.IO)


    job.launch {

        callAnotherFunction()

        launch {
            delay(200)
            println("Running job 1")
        }

        launch {
            delay(100)
            println("Running job 2")
        }

        launch {
            delay(400)
            println("Running job 3")
        }

    }

    Thread.sleep(1000)

}

suspend fun callAnotherFunction() {
    delay(700)
    println("Running Another Job")

}
