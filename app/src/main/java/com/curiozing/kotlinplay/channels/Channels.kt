package com.curiozing.kotlinplay.channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main() = coroutineScope {

    val channel = produce<Int> {

        send(10)
        delay(1000)

        send(20)
        delay(1000)

        send(30)
        delay(1000)

        send(40)
        delay(1000)
    }


    channel.consumeEach {
        println("Received $it")
    }
}