package com.curiozing.kotlinplay.mutex

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


val mutex = Mutex()
var balance = 5000 // Shared resource

fun main(): Unit = runBlocking {
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
}
