package com.curiozing.kotlinplay.kotlinFlow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Flow
fun main() = runBlocking(Dispatchers.Default){
    launch {
        coldFlow().collect{
            println("Cold Collector 1 - $it")
        }

    }

    launch {
        coldFlow().collect{
            println("Cold Collector 2 - $it")
        }
    }

    val job = CoroutineScope(Dispatchers.Default)
    val hotFlow = MutableSharedFlow<String>()

    job.launch {
        repeat(5){
            println("Hot FLow $it")
            delay(200)
            hotFlow.emit("Hot $it")
        }
    }

    job.launch {
        hotFlow.collect{
            println("Hot Collector 1 - $it")
        }
    }

    job.launch {
        hotFlow.collect{
            println("Hot Collector 2 - $it")
        }
    }

    delay(6000)

}


fun coldFlow() = flow {
    repeat(5){
        emit("Cold $it")
    }
}