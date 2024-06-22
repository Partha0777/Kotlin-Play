package com.curiozing.kotlinplay.kotlinFlowExceptions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
 fun main() {
        dataCollection().onCompletion { cause ->
            if (cause == null) {
                println("Completed Normally")
            } else {
                println("Completed with Exceptions")
            }
        }.onEach {
            println("Received data $it")
        }.catch {
            println("Exception catch $it")

        }
            .launchIn(CoroutineScope(Dispatchers.Default))

     Thread.sleep(2000)
}

fun dataCollection(): Flow<String> = flow {
    emit("Hello")
    delay(500)
    emit("Hello1")
    delay(500)
    emit("Hello2")
    throw Exception("Error")
}