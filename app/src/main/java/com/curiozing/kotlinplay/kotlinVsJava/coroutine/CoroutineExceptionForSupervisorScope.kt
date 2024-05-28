package com.curiozing.kotlinplay.kotlinVsJava.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

/*fun main() = runBlocking<Unit>{

        supervisorScope {

            launch {
                throw RuntimeException()
            }
            launch {
                println("Helooo")
            }
        }

}*/

fun main() {
    val job = CoroutineScope(SupervisorJob())

    job.launch{

        //supervisorScope {
        val job1 = CoroutineScope(SupervisorJob())

        try {
            val data = job1.async {
                throw RuntimeException()
            }
            data.await()
        }catch (e:Exception){
            println("Caught $e")
        }

        launch {
                delay(200)
                println("Helooo 1")

            }

       // }

    }

    job.launch {
        delay(200)
        println("Helooo 2")
    }


    Thread.sleep(1000)
}