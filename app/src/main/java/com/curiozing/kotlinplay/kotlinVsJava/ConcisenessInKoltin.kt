package com.curiozing.kotlinplay.kotlinVsJava


fun main(){
    val conciseness = ConcisenessInKoltin()
    conciseness.loadList()
}
class ConcisenessInKoltin {

    fun loadList(){
        val data = listOf(1,2,3,4,5)
        val  evenNumbers = data.filter { it % 2 == 0 }
        println(evenNumbers)
    }
}