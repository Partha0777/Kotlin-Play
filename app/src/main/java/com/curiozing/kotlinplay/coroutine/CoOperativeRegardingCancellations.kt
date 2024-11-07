package com.curiozing.kotlinplay.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    /* val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
     val splitList: MutableList<List<Int>> = mutableListOf()
     val splitCount = 3
     var i = 0
     while (i < list.size) {
         val split: List<Int> = list.subList(i, min(i + splitCount, list.size))
         i += splitCount
         splitList.add(split)
     }
     println("Splited ---> $splitList")

     val job = launch {
         repeat(5) {
             *//*  if (isActive){
                  println("Its $it time")
                  Thread.sleep(300)
              }else{
                  println("Coroutine is Cancelled")
                  throw  CancellationException()
              }*//*

            yield()
            //ensureActive()
            Thread.sleep(200)
            println("Its $it time")

        }
    }
    delay(300)
    job.cancel()*/

    val value = coroutineScope {
        val data = callApi()
        launch {
            saveToLocal(data)
        }
        println("Finished")
        data
    }

    println(value)
}

suspend fun callApi(): String {
    delay(2000)
    println("Called API....")
    return "Partha"
}

suspend fun saveToLocal(data: String) {
    delay(2000)
    println("$data Data Stored....")
}