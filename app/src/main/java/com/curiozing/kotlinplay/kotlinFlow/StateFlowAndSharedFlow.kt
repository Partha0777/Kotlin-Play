package com.curiozing.kotlinplay.kotlinFlow

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

fun main() {

    val list = listOf(19,8,2,45,7,3)
    val temp = mutableListOf<Int>()

    list.forEach {
        var i = 0
        while (temp.size > i && it > temp[i]){
            i++
        }
        temp.add(i,it)
    }

    print(temp)
}
