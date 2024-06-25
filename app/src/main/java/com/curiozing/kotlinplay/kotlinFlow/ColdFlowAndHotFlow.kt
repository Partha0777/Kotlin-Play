package com.curiozing.kotlinplay.kotlinFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Flow
fun main() = runBlocking{
    launch {
        coldFlow().collect{
            println("Collector 1 - $it")
        }

    }

    launch {
        coldFlow().collect{
            println("Collector 2 - $it")
        }
    }

    delay(300)



}


fun coldFlow() = flow {
    repeat(5){
        emit("Cold $it")
    }
}