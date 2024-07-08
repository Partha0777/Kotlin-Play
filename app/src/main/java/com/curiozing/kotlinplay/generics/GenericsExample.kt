package com.curiozing.kotlinplay.generics


fun main() {

    val intData = listOf(1,2,3,4,5,6,7)
    val stringData = listOf("Kan", "Partha", "Sarathy", "Curio")

    GenericsExample(stringData).find("Sarathy"){
        println("Found $it")
    }

}

class GenericsExample<T>(var list:List<T>) {

    fun find(value: T, found : (T) -> Unit ){
        val data = list.filter {
            it == value
        }
        found(data.first())
    }

}