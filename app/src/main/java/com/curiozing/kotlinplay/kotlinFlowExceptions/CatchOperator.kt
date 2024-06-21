package com.curiozing.kotlinplay.kotlinFlowExceptions

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion

suspend fun main(){
    dataFlow().onCompletion { cause ->
        if (cause == null){
            println("Completed Normally")
        }else{
            println("Completed with Exceptions")
        }
    }.catch {
        println("Catch with Exceptions $it")
    }.collect{
        println(it)
    }
}

private fun dataFlow(): Flow<String> = flow {
    emit("Hello")
    delay(500)
    emit("Hello1")
    delay(500)
    emit("Hello2")
    throw Exception("Error")
}