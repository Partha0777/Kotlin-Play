package com.curiozing.kotlinplay.kotlinVsJava.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.ClassCastException

class CoroutineExample {
    fun startCoroutine() {
        CoroutineScope(Dispatchers.Main).launch {


        }
    }
}

fun main() {
    val job = CoroutineScope(Dispatchers.IO + SupervisorJob())
    //val job = CoroutineScope(Dispatchers.IO)


    job.launch {


        /*val job1 = CoroutineScope(Dispatchers.IO)

            job1.launch {
            delay(100)
            println("Cancel Running job 1")
        }

        val job2 = CoroutineScope(Dispatchers.IO)

            job2.launch {
            delay(100)
            println("Cancel Running job 2")
        }*/




        launch {
            delay(200)
            println("Running job 1")
            throw ClassCastException()

        }
        callAnotherFunction()

        launch {
            delay(100)
            println("Running job 2")

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
