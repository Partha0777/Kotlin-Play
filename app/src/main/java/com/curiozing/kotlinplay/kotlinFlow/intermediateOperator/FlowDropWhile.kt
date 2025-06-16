package com.curiozing.kotlinplay.kotlinFlow.intermediateOperator

import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    flowOf(1, 2, 3, 4, 5)
        .dropWhile { it <= 2 }
        .collect {
            println("Take $it")
        }
}