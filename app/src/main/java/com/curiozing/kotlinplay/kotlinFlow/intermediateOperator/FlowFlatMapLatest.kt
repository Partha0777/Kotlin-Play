package com.curiozing.kotlinplay.kotlinFlow.intermediateOperator

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main():Unit = runBlocking {

    val userInput = flow {
        emit("A")
        delay(100) // User types quickly
        emit("AB")
        delay(100)
        emit("ABC")
    }

   userInput
       .flatMapLatest {query ->
        flow {
            delay(200) // Simulated API call
            emit("Results for: $query")
        }
    }.collect{
        println("$it")
    }


}