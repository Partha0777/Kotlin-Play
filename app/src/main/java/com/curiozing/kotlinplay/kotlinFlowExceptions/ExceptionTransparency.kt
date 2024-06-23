package com.curiozing.kotlinplay.kotlinFlowExceptions

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf


suspend fun main() {

   flow {
       try {
           emit("1")
       }catch (e:Exception){
           print("Exceptions $e")
       }

   }.collect{
       throw Exception("Error")
       println("Hello $it")
   }

}

