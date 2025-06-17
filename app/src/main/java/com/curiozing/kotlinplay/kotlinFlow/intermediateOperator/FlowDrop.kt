package com.curiozing.kotlinplay.kotlinFlow.intermediateOperator

import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    flowOf(1,2,3,4,5)
        .drop(3)
        .collect{
            println("Take $it")
        }
}