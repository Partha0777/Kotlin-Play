package com.curiozing.kotlinplay.kotlinFlow.intermediateOperator

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main() : Unit = runBlocking{
    flowOf(1,2).flatMapConcat { value ->
        flow {
            emit("$value A")
            kotlinx.coroutines.delay(100)
            emit("$value B")
        }
    }.collect{
        println(it)
    }
}