package com.curiozing.kotlinplay.mutex

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


val mutex = Mutex()
var balance = 5000 // Shared resource

/*fun main(): Unit = runBlocking {
    coroutineScope {
        launch {
            repeat(10) {
                launch {
                    getMoney(500)
                }
            }
        }
    }
}

suspend fun addMoney(money: Int) {
    mutex.withLock {
        balance += money
        println("Added $money, Balance is $balance")
    }
}

suspend fun getMoney(money: Int) {
    mutex.withLock {
        if (balance >= money) {
            balance -= money
            println("Deducted $money, Balance is $balance")
        } else {
            println("Not enough balance to deduct $money, Balance is $balance")
        }
    }
}*/
fun main() = runBlocking {
    val counter = SharedCounter()
    val coroutineCount = 10

    // Launch multiple coroutines to increment the counter
    val jobs = List(coroutineCount) {
        launch {
            repeat(100) {
                counter.increment()
            }
        }
    }

    jobs.forEach { it.join() }

    println("Final Counter Value: ${counter.value}")
}

class SharedCounter {
    private var _value = 0
    private val mutex = Mutex()

    val value: Int
        get() = _value

    suspend fun increment() {
        mutex.withLock {
            _value++
        }
    }
}