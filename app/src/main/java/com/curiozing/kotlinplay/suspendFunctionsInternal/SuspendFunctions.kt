package com.curiozing.kotlinplay.suspendFunctionsInternal

import kotlinx.coroutines.delay
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

suspend fun main() {
    val name = fetchUser()
    storeUser(name)
    MainContinuation(null).resumeWith(Result.success(Unit))
}

suspend fun fetchUser(): String {
    println("Fetching User...")
    delay(500)
    return "Partha"
}

suspend fun storeUser(name: String) {
    delay(500)
    println("$name stored")
}


class MainContinuation(val completion: Continuation<Unit>?) : Continuation<Unit> {
    var state = 0 // Represents the current execution state
    var result: Any? = null // Stores intermediate results

    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resumeWith(result: Result<Unit>) {
        this.result = result.getOrNull()
        when (state) {
            0 -> {
                state = 1 // Move to fetching state
                fetchUserContinuation(this)
            }

            1 -> {
                val name = result as String // Retrieve stored result
                state = 2 // Move to storing state
                storeUserContinuation(name, this)
            }

            2 -> {
                println("Execution completed")
            }
        }
    }
}

fun fetchUserContinuation(continuation: MainContinuation) {
    println("Fetching User...")
    continuation.state = 1
    delay(500) { result -> // Simulating suspend function
        continuation.resumeWith(Result.success("Partha") as Result<Unit>)
    }
}

fun storeUserContinuation(name: String, continuation: MainContinuation) {
    continuation.state = 2
    delay(500) { // Simulating suspend function
        println("$name stored")
        continuation.resumeWith(Result.success(Unit))
    }
}

fun delay(time: Long, callback: (Result<Unit>) -> Unit) {
    Thread.sleep(time) // Simulate suspension
    callback(Result.success(Unit))
}
