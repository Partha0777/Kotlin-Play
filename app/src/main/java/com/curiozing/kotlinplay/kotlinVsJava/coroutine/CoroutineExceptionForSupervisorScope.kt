package com.curiozing.kotlinplay.kotlinVsJava.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
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

            launch {
                throw RuntimeException()
            }
            launch {
                println("Helooo")
            }

    }


    Thread.sleep(1000)
}