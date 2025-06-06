package com.curiozing.kotlinplay.kotlinFlow.intermediateOperator

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main():Unit = runBlocking {
    flowOf(1,2).flatMapMerge {value ->
        flow {
            emit("$value A")
            kotlinx.coroutines.delay(100)
            emit("$value B")
        }
    }.collect{
        println("$it")
    }
}