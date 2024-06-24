package com.curiozing.kotlinplay.coroutine

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking {

    val job = launch(Dispatchers.IO) {
        repeat(5){
         /*  if (isActive){
               println("Its $it time")
               Thread.sleep(300)
           }else{
               println("Coroutine is Cancelled")
               throw  CancellationException()
           }*/

            yield()
            //ensureActive()
            Thread.sleep(200)
            println("Its $it time")

        }
    }
    delay(300)
    job.cancel()

}