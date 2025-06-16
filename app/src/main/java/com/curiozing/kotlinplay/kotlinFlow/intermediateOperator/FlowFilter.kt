package com.curiozing.kotlinplay.kotlinFlow.intermediateOperator

import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf

suspend fun main() {

    flowOf(1, 2, 3, 4, 5, 6, 7)
        .filter {
            it % 2 == 0
        }
        .collect {
            println("Data $it")
        }
}