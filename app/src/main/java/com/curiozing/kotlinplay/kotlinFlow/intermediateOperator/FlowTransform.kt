package com.curiozing.kotlinplay.kotlinFlow.intermediateOperator

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.transform


suspend fun main() {

    flowOf(1, 2, 3, 4, 5, 6, 7, 8)
        .transform {
            if (it % 2 == 0) {
                emit(it)
            }
            if (it == 3) {
                emit(it)
            }
        }
        .collect {
            println("Data $it")
        }
}