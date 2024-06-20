package com.curiozing.kotlinplay.kotlinFlowExceptions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

fun main() {


}

fun data(): Flow<String> = flow {
    emit("Hello")
}