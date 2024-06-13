package com.curiozing.kotlinplay.kotlinFlow.intermediateOperator

import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOf

suspend fun main() {

    flowOf(1,2,2,4,2,6,5,5).distinctUntilChanged()
        .collect{
            println("Data "+it)
    }
}