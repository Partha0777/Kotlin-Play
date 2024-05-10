package com.curiozing.kotlinplay.kotlinVsJava.conciseness


fun main() {
    val conciseness = ConcisenessInKotlin()
    conciseness.loadList()
}

class ConcisenessInKotlin {

    fun loadList() {
        val data = listOf(1, 2, 3, 4, 5)
        val evenNumbers = data.filter { it % 2 == 0 }
        println(evenNumbers)
    }
}