package com.curiozing.kotlinplay.kotlinFlowExceptions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


suspend fun main() {

    eData().collect{
       throw Exception("Error")
       println("Hello $it")
   }

}

fun eData():Flow<String> = flow {
    try {
        emit("2")
    }catch (e:Exception){
        print("Exceptions $e")
    }
}

