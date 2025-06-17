package com.curiozing.kotlinplay.kotlinFlow.intermediateOperator

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take

suspend fun main() {
    flowOf(1, 2, 3, 4, 5)
        .take(3)
        .collect {
            println("Take $it")
        }
}