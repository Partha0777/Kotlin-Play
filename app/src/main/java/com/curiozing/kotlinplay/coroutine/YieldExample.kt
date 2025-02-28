package com.curiozing.kotlinplay.coroutine;

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

suspend fun downloadFile(url: String, delay: Long): String {
        println("Downloading $url...")
        delay(delay)
        return "Downloaded $url"
}


fun main(): Unit = runBlocking {

        launch {
                for (i in 1..5) {
                        println("Computation $i in Coroutine 1")
                }
        }

        launch {
                for (i in 1..5) {
                        println("Task $i in Coroutine 2")
                }
        }

}
