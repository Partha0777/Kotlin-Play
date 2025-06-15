package com.curiozing.kotlinplay.kotlinFlow.intermediateOperator

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main():Unit = runBlocking {
    val input = flow{
        emit("a")
        delay(100)
        emit("b")
        delay(100)
        emit("c")
    }

    input.flatMapLatest {
        flow {
            delay(200)
            emit(it)
        }
    }.collect{
        println(it)
    }


}