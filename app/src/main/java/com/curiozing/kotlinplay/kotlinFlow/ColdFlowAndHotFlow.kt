package com.curiozing.kotlinplay.kotlinFlow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking(Dispatchers.Default) {

    launch {
        coldFlow().collect {
            delay(200)
            println("Cold Collector 1 - $it")
        }

    }

    delay(2000)

    launch {
        coldFlow().collect {
            println("Cold Collector 2 - $it")
        }
    }

    val job = CoroutineScope(Dispatchers.Default)
    val hotFlow = MutableSharedFlow<String>()

    val stateFlow = MutableStateFlow(1)

    job.launch {
        repeat(5) {
            delay(500)
            hotFlow.emit("Hot $it")
        }
    }

    stateFlow.value = 2
    delay(2000)
    stateFlow.value = 3

    job.launch {
        hotFlow
            .collect {
                println("Hot Collector 2 - $it")
            }
    }

    delay(5000)

    job.launch {
        hotFlow
            .collect {
                println("Hot Collector 3 - $it")
            }
    }


    delay(10000)
    stateFlow

    delay(50)

}


fun coldFlow() = flow {
    repeat(5) {
        emit("Cold $it")
    }
}